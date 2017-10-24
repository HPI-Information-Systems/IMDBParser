package de.hpi.data_change.imdb.data;

import de.hpi.data_change.data.Entity;
import de.hpi.data_change.data.Property;

import java.util.List;

public class PartOfMovieEntity implements CustomEntity{

    private List<Property> properties;
    private String title;

    public PartOfMovieEntity(String title,List<Property> properties) {
        this.properties = properties;
        this.title = title;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public Entity toEntity() {
        return new Entity(title, properties);
    }
}
