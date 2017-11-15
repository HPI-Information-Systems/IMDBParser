package de.hpi.data_change.imdb.data;

import de.hpi.data_change.data.Entity;
import de.hpi.data_change.data.Property;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Plot implements CustomEntity{

    private static final String plotDescriptionPropertyName = "plotDescription";
    private static final String unknownAuthorConstant = "anonymous";

    private String title;
    private String plotDescription;
    private String author;
    private final String authorPropertyName = "author";

    public Plot(String title, String plotDescription, String author) {
        this.title = title;
        this.plotDescription = plotDescription;
        this.author = author;
    }

    public Plot(String title, String plotDescription) {
        this.title = title;
        this.plotDescription = plotDescription;
        this.author = unknownAuthorConstant;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public Entity toEntity() {
        List<Property> keyProperties = new ArrayList<>();
        keyProperties.add(new Property("title",title));
        keyProperties.add(new Property(authorPropertyName,author));
        List<Property> props = new ArrayList<>();
        props.add(new Property(authorPropertyName,author));
        props.add(new Property("title",title));
        props.add(new Property(plotDescriptionPropertyName,plotDescription));
        return new Entity(Entity.buildUniqueNameFromProperties(keyProperties),props);
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return plotDescription;
    }
}
