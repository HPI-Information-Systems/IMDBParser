package de.hpi.data_change.imdb.data;

import de.hpi.data_change.data.Entity;
import de.hpi.data_change.data.Property;

import java.util.Arrays;
import java.util.List;


/**
 * An entity that can have a property that has a variable length (List)
 */
public abstract class MultiPropertyEntity implements CustomEntity{

    private String name;
    private List<String> propertyValues;

    public MultiPropertyEntity(String name, List<String> workTitles) {
        this.name = name;
        this.propertyValues = workTitles;
    }

    @Override
    public String toString() {
        return getPersonType() + "{" +
                "name='" + name + '\'' +
                ", propertyValues=" + propertyValues +
                '}';
    }

    protected abstract String getPersonType();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MultiPropertyEntity other = (MultiPropertyEntity) o;

        if (name != null ? !name.equals(other.name) : other.name != null) return false;
        return propertyValues != null ? propertyValues.equals(other.propertyValues) : other.propertyValues == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (propertyValues != null ? propertyValues.hashCode() : 0);
        return result;
    }

    public Entity toEntity(){
        return new Entity(name, getProperties());
    }

    protected List<Property> getProperties() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i< propertyValues.size(); i++) {
            String workTitle  = propertyValues.get(i);
            builder.append("\"");
            builder.append(workTitle);
            builder.append("\"");
            if(i!= propertyValues.size()-1){
                builder.append(",");
            }
        }
        builder.append("]");
        return Arrays.asList(new Property(getPropertyName(),builder.toString()));
    }

    protected String getPropertyName() {
        return "works";
    }
}
