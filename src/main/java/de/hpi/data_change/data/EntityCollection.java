package de.hpi.data_change.data;

import de.hpi.data_change.imdb.IOConstants;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class EntityCollection {

    private Map<String,Entity> entities;
    private LocalDate timestamp;

    public EntityCollection(List<Entity> entities, LocalDate timestamp) {
        this.entities = new HashMap<>();
        for (Entity entity : entities) {
            this.entities.put(entity.getName(),entity);
        }
        this.timestamp = timestamp;
        //assert entity uniqueness:
        assert(entities.size() == this.entities.size());
    }

    /***
     * Serializes the collection of entities into an initial change file, meaning that for each (entity,property) the line entity,property,propertyValue,timestamp will be written into the file.
     * All entries get the timestamp of this collection.
     * @param file the file to serialize to
     * @throws IOException
     */
    public void toIntitialChangeFile(File file) throws IOException {
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file),StandardCharsets.UTF_8));
        entities.values().forEach( e -> e.writeToChangeFile(writer,timestamp));
        writer.close();
    }

    public void appendChanges(EntityCollection olderVersion,File file) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file,true),StandardCharsets.UTF_8));
        insertNewEntities(olderVersion, writer);
        handleDeletedEntities(olderVersion, writer);
        //modified entity-property relationships:
        handleEntityChanges(olderVersion, writer);
        writer.close();
    }

    private void handleEntityChanges(EntityCollection olderVersion, PrintWriter writer) {
        Set<String> remainingEntityKeys = entities.keySet().stream()
                .filter(k -> olderVersion.entities.keySet().contains(k))
                .collect(Collectors.toSet());
        for(String entityName : remainingEntityKeys){
            Entity oldEntity = olderVersion.entities.get(entityName);
            Entity newEntity = entities.get(entityName);
            if(!oldEntity.equals(newEntity)){
                for(int j =0;j<newEntity.getProperties().size();j++){
                    Property prop = newEntity.getProperties().get(j);
                    if(!oldEntity.containsProperty(prop)){
                        prop.writeln(writer, timestamp, newEntity.getName());
                    }
                }
                Set<String> newPropNames = newEntity.getProperties().stream()
                        .map(p -> p.getName())
                        .collect(Collectors.toSet());
                List<Property> deletedProperties = oldEntity.getProperties().stream()
                        .filter(p -> !newPropNames.contains(p.getName()))
                        .collect(Collectors.toList());
                for (Property deletedProperty : deletedProperties) {
                    Property deletedProp = new Property(deletedProperty.getName(), IOConstants.NULL_REPRESENTATION);
                    deletedProp.writeln(writer,timestamp,newEntity.getName());
                }
            }
        }
    }

    private void handleDeletedEntities(EntityCollection olderVersion, PrintWriter writer) {
        //TODO: how to handle this case? Entities getting deleted? --> for now we just delete all its properties
        Set<Entity> deletedEntities = olderVersion.entities.keySet().stream()
                .filter(k -> !entities.keySet().contains(k))
                .map(k -> olderVersion.entities.get(k))
                .collect(Collectors.toSet());
        for (Entity deletedEntity : deletedEntities) {
            deletedEntity.getProperties().stream()
                .map(p -> new Property(p.getName(),IOConstants.NULL_REPRESENTATION))
                .forEach(p -> p.writeln(writer,timestamp,deletedEntity.getName()));
        }
    }

    private void insertNewEntities(EntityCollection olderVersion, PrintWriter writer) {
        Set<Entity> newEntities = entities.keySet().stream()
                .filter(k -> !olderVersion.entities.keySet().contains(k))
                .map(k -> entities.get(k))
                .collect(Collectors.toSet());
        //append new entities to file:
        for (Entity newEntity : newEntities) {
            newEntity.getProperties().forEach(p -> p.writeln(writer,timestamp,newEntity.getName()));
        }
    }

    private boolean containsTriple(Entity entity, Property prop) {
        if(entities.containsKey(entity.getName())){
            Entity myCorrespondingEntity = entities.get(entity.getName());
            if(entity.containsProperty(prop)){
                return true;
            }
        }
        return false;
    }


}
