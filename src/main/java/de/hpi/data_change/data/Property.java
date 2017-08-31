package de.hpi.data_change.data;

import de.hpi.data_change.imdb.IOConstants;
import org.apache.commons.csv.CSVPrinter;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

public class Property {

    private String name;
    private String value;

    public Property(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Property property = (Property) o;

        if (name != null ? !name.equals(property.name) : property.name != null) return false;
        return value != null ? value.equals(property.value) : property.value == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    public void writeln(PrintWriter writer, LocalDate timestamp, String entityName) {
        writer.println("\"" + entityName +"\"" + "," + "\"" +name +"\"" + "," + "\"" + value + "\"" + "," + timestamp.format(IOConstants.changeDBFormatter));
    }

    public void writeln(CSVPrinter writer, LocalDate timestamp, String entityName) throws IOException {
        writer.printRecord(entityName, name, value,timestamp.format(IOConstants.changeDBFormatter));
    }

    @Override
    public String toString() {
        return "Property{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    //private String escapeString(String entityName) {
    //    return entityName.replaceAll("\\\\","\\\\\\\\").replaceAll("\\\"","\\\\\\\""); //sometimes java regexes require an enourmous amount of escape chars...
   // }

    public void write(PrintWriter writer, LocalDate timestamp, String entityName) {
        writer.write("\"" + entityName +"\"" + "," + "\"" +name +"\"" + "," + "\"" + value + "\"" + "," + timestamp.format(IOConstants.changeDBFormatter));
    }
}
