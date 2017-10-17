package de.hpi.data_change.imdb.data;

import de.hpi.data_change.data.Entity;
import de.hpi.data_change.data.Property;
import de.hpi.data_change.imdb.parsing.InfoExtractor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


/**
 * An entity that can have a property that has a variable length (List)
 */
public abstract class MultiPropertyEntity implements CustomEntity{

    protected List<Property> rawProperties;
    protected List<Property> keyProperties;
    private static InfoExtractor infoExtractor = new InfoExtractor();
    private String title;

    public List<Property> getRawProperties() {
        return rawProperties;
    }

    public MultiPropertyEntity(List<Property> keyProperties, String additionalInfo) {
        this.keyProperties = keyProperties;
        this.rawProperties = infoExtractor.extractAdditionalInfo(additionalInfo);
    }
    
    protected Property extractTrueProperty(String value) {
        if(value.split("\\s").length>1){
            String propName = value.split("\\s")[0];
            String propValue = value.substring(value.indexOf(' ')+1);
            return new Property(propName,propValue);
        } else{
            return new Property(value,"TRUE"); //TODO: workaround for now
        }
    }

    @Override
    public Entity toEntity() {
        List<Property> props = new ArrayList<>();
        props.addAll(keyProperties);
        props.addAll(getTrueProperties());
        return new Entity(Entity.buildUniqueNameFromProperties(keyProperties),props);
    }

    protected List<Property> getTrueProperties() {
        return rawProperties.stream().map( prop -> extractTrueProperty(prop.getValue())).collect(Collectors.toList());
    }

    public String getTitle() {
        return keyProperties.stream().filter(p -> p.getName().equals("title")).findAny().get().getValue();
    }

    public String getName() {
        return keyProperties.stream().filter(p -> p.getName().equals("name")).findAny().get().getValue();
    }
}
