package de.hpi.data_change.data;

import org.apache.commons.csv.CSVPrinter;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Entity {

    private List<Property> properties;
    private String name;

    public Entity( String name,List<Property> properties) {
        this.properties = properties;
        this.name = name;
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

    public boolean containsProperty(Property prop) {
        return properties.contains(prop);
    }
}
