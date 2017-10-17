package de.hpi.data_change.imdb.data;

import de.hpi.data_change.data.Entity;
import de.hpi.data_change.data.Property;

import java.util.ArrayList;
import java.util.List;

public class StandardNonMovieEntity implements CustomEntity {

    private final List<Property> rawProperties;
    private String name;
    private String movieTitle;
    private List<Property> trueProperties = new ArrayList<>();

    public StandardNonMovieEntity(String name, String movieTitle, List<Property> rawProperties) {
        this.name = name;
        this.movieTitle = movieTitle;
        this.rawProperties = rawProperties;
        if(!rawProperties.isEmpty()) {
            rawProperties.forEach(p -> extractTrueProperty(p.getValue()));
        }
    }

    private void extractTrueProperty(String value) {
        if(value.split("\\s").length>1){
            String propName = value.split("\\s")[0];
            String propValue = value.substring(value.indexOf(' ')+1);
            trueProperties.add(new Property(propName,propValue));
        } else{
            trueProperties.add(new Property(value,"TRUE")); //TODO: workaround for now
        }
    }

    public String getName() {
        return name;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public List<Property> getRawProperties() {
        return rawProperties;
    }

    @Override
    public Entity toEntity() {
        List<Property> props = new ArrayList<>();
        props.add(new Property("name", name));
        props.add(new Property("title",movieTitle));
        if(!trueProperties.isEmpty()){
            props.addAll(trueProperties);
        }
        return new Entity(Entity.buildUniqueNameFromKeys(name,movieTitle),props);
    }

    @Override
    public String toString() {
        return "StandardNonMovieEntity{" +
                "name='" + name + '\'' +
                ", movieTitle='" + movieTitle + '\'' +
                '}';
    }
}
