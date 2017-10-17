package de.hpi.data_change.data;

import de.hpi.data_change.imdb.data.CustomEntity;
import org.apache.commons.csv.CSVPrinter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Entity implements CustomEntity {


    private static final String VALUE_LIST_DELIMITER = ",";
    public static final String KEY_SEPARATOR = "|";


    private static Logger logger = LogManager.getLogger(EntityCollection.class);


    private String name;
    private List<Property> properties;

    public Entity( String name,List<Property> properties) {
        this.properties = properties;
        this.name = name;
    }

    public Entity(String entity, String property, String value) {
        this.name = entity;
        this.properties = Arrays.asList(new Property(property,value));
    }

    public List<Property> getProperties() {
        return properties;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Entity entity = (Entity) o;

        if (properties != null ? !properties.equals(entity.properties) : entity.properties != null) return false;
        return name != null ? name.equals(entity.name) : entity.name == null;
    }

    @Override
    public int hashCode() {
        int result = properties != null ? properties.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public void writeToChangeFile(PrintWriter writer, LocalDate timestamp) {
        for (int i=0;i<properties.size();i++) {
            Property property = properties.get(i);
            property.writeln(writer, timestamp, name);
        }
    }

    public void writeToChangeFile(CSVPrinter writer, LocalDate timestamp) throws IOException {
        for (int i=0;i<properties.size();i++) {
            Property property = properties.get(i);
            property.writeln(writer, timestamp, name);
        }
    }

    @Override
    public String toString() {
        return "Entity{" +
                "name='" + name + '\'' +
                ", properties=" + properties +
                '}';
    }

    public boolean containsProperty(Property prop) {
        return properties.contains(prop);
    }

    //convenience implementation of interface so parsers can use raw entities
    @Override
    public Entity toEntity() {
        return this;
    }

    public String getValue(String name) {
        return properties.stream().filter(p -> p.getName().equals(name)).map(p -> p.getValue()).findFirst().get();
    }

    public boolean containsPropertyName(String name) {
        return properties.stream().anyMatch(p -> p.getName().equals(name));
    }

    /**
     * merges this entity with another entity by concatenating values of properties that have the same name and keeping all properties from both entities that have different names
     * @param other
     * @return
     */
    public Entity concatenate(Entity other) {
        assert(getName().equals(other.getName()));
        List<Property> props = new ArrayList<>();
        for (Property prop : getProperties()){
            if(other.containsPropertyName(prop.getName())){
                props.add(new Property(prop.getName(),prop.getValue() + VALUE_LIST_DELIMITER + other.getValue(prop.getName())));
            } else{
                props.add(prop);
            }
        }
        //add the remaining properties of the other entity:
        other.getProperties()
                .stream()
                .filter( p -> props.stream().anyMatch(p1 -> p1.getName().equals(p)))
                .forEach(p -> props.add(p));
        return new Entity(name,props);
    }

    public static List<Entity> concatenateByKey(List<Entity> allMoviesWithDirectors) {
        HashMap<String,Entity> map = new HashMap<>();
        for(Entity entity : allMoviesWithDirectors) {
            if (!map.containsKey(entity.getName())){
                map.put(entity.getName(), entity);
            } else{
                map.put(entity.getName(),map.get(entity.getName()).concatenate(entity));
            }
        }
        return map.values().stream().collect(Collectors.toList());
    }

    public static String buildUniqueNameFromKeys(String key1, String key2) {
        return key1 + KEY_SEPARATOR + key2;
    }

    public static String buildUniqueNameFromProperties(List<Property> keyProperties) {
        return keyProperties.stream().map( k -> k.getValue()).reduce( (s1,s2) -> s1 + KEY_SEPARATOR + s2).get();
    }
}
