package de.hpi.data_change.data;

import de.hpi.data_change.imdb.IOConstants;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.QuoteMode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EntityCollection {

    Logger logger = LogManager.getLogger(EntityCollection.class);

    private Map<String,Entity> entities;
    private LocalDate timestamp;

    public static boolean checkDublicates(List<Entity> entities){
        Map<String,List<Entity>> byName = entities.stream().collect(Collectors.groupingBy( e -> e.getName()));
        Set<List<Entity>> res = byName.values().stream().filter(l -> l.size() > 1).collect(Collectors.toSet());
        for (List<Entity> re : res) {
            System.out.println("new group:");
            re.forEach( r -> System.out.println(r));
        }
        System.out.println("num Dublicate Key: " + res.size());
        return res.size() == 0;
    }

    public EntityCollection(List<Entity> entityList, LocalDate timestamp) {
        this.entities = new HashMap<>();
        for (Entity entity : entityList) {
            if(entities.containsKey(entity.getName())){
                entities.put(entity.getName(),entities.get(entity.getName()).merge(entity));
            } else {
                this.entities.put(entity.getName(), entity);
            }
        }
        this.timestamp = timestamp;
        //assert entity uniqueness:
        if(entities.size() !=this.entities.size()){
            logger.warn("Found dublicate entities, size of List: {} Size of Set: {}",entities.size(),this.entities.size());
        }
        //assert(entities.size() == this.entities.size());
    }

    public EntityCollection(Stream<Entity> entities, LocalDate timestamp) {
        this(entities.collect(Collectors.toList()),timestamp);
    }

    /***
     * Serializes the collection of entities into an initial change file, meaning that for each (entity,property) the line entity,property,propertyValue,timestamp will be written into the file.
     * All entries get the timestamp of this collection.
     * @param file the file to serialize to
     * @throws IOException
     */
    public void toIntitialChangeFile(File file) throws IOException {
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file),StandardCharsets.UTF_8));
        CSVFormat format = CSVFormat.DEFAULT.withEscape('\\').withQuoteMode(QuoteMode.ALL);
        CSVPrinter printer = new CSVPrinter(writer,format);
        for (Entity entity : entities.values()) {
            entity.writeToChangeFile(printer,timestamp);
        }
        printer.close();
    }

    public void appendChanges(EntityCollection olderVersion,File file) throws IOException {
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file,true),StandardCharsets.UTF_8));
        CSVFormat format = CSVFormat.DEFAULT.withEscape('\\').withQuoteMode(QuoteMode.ALL);
        CSVPrinter printer = new CSVPrinter(writer,format);
        insertNewEntities(olderVersion, printer);
        handleDeletedEntities(olderVersion, printer);
        //modified entity-property relationships:
        handleEntityChanges(olderVersion, printer);
        printer.close();
    }

    private void handleEntityChanges(EntityCollection olderVersion, CSVPrinter writer) throws IOException {
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

    private void handleDeletedEntities(EntityCollection olderVersion, CSVPrinter writer) throws IOException {
        Set<Entity> deletedEntities = olderVersion.entities.keySet().stream()
                .filter(k -> !entities.keySet().contains(k))
                .map(k -> olderVersion.entities.get(k))
                .collect(Collectors.toSet());
        for (Entity deletedEntity : deletedEntities) {
            List<Property> allProperties = deletedEntity.getProperties().stream()
                    .map(p -> new Property(p.getName(), IOConstants.NULL_REPRESENTATION)).collect(Collectors.toList());
            for (Property property : allProperties) {
                property.writeln(writer,timestamp,deletedEntity.getName());
            }
        }
    }

    private void insertNewEntities(EntityCollection olderVersion, CSVPrinter writer) throws IOException {
        Set<Entity> newEntities = entities.keySet().stream()
                .filter(k -> !olderVersion.entities.keySet().contains(k))
                .map(k -> entities.get(k))
                .collect(Collectors.toSet());
        //append new entities to file:
        for (Entity newEntity : newEntities) {
            for (Property property : newEntity.getProperties()) {
                property.writeln(writer,timestamp,newEntity.getName());
            }
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
