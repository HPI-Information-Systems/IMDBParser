package de.hpi.data_change.imdb.data;

import de.hpi.data_change.data.Entity;
import de.hpi.data_change.data.Property;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractCreativePerson implements CustomEntity{

    private static final String PROPERTY_NAME = "works";
    private String name;
    private List<String> workTitles;

    public AbstractCreativePerson(String name, List<String> workTitles) {
        this.name = name;
        this.workTitles = workTitles;
    }

    @Override
    public String toString() {
        return getPersonType() + "{" +
                "name='" + name + '\'' +
                ", workTitles=" + workTitles +
                '}';
    }

    protected abstract String getPersonType();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractCreativePerson other = (AbstractCreativePerson) o;

        if (name != null ? !name.equals(other.name) : other.name != null) return false;
        return workTitles != null ? workTitles.equals(other.workTitles) : other.workTitles == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (workTitles != null ? workTitles.hashCode() : 0);
        return result;
    }

    public Entity toEntity(){
        return new Entity(name,workTitlesToString());
    }

    private List<Property> workTitlesToString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i=0;i<workTitles.size();i++) {
            String workTitle  = workTitles.get(i);
            builder.append("\"");
            builder.append(workTitle);
            builder.append("\"");
            if(i!=workTitles.size()-1){
                builder.append(",");
            }
        }
        builder.append("]");
        return Arrays.asList(new Property(PROPERTY_NAME,builder.toString()));
    }
}
