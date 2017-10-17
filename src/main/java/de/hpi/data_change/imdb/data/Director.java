package de.hpi.data_change.imdb.data;

import de.hpi.data_change.data.Entity;
import de.hpi.data_change.data.Property;
import de.hpi.data_change.imdb.parsing.InfoExtractor;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Director implements CustomEntity {

    private static InfoExtractor extractor = new InfoExtractor();
    private final List<Property> rawProperties;
    private final String name;
    private String title;

    public Director(String name, String title, String additionalInfo) {
        this.name = name;
        this.title = title;
        rawProperties = extractor.extractAdditionalInfo(additionalInfo);
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
        if(name.equals("Kriegman, Mitchell") && title.equals("\"The Book of Pooh\" (2001) {I Could Have Laughed All Night/X Spots the Mark (#1.7)}")){
            System.out.println("lol");
        }
        List<Property> keyProperties=new ArrayList<>();
        List<Property> trueProperties=new ArrayList<>();
        keyProperties.add(new Property("name",name));
        keyProperties.add(new Property( "title",title));
        for(Property prop : rawProperties){
            Property propNew = extractTrueProperty(prop.getValue());
            if(propNew.getName().contains("segment")){
                //key things
                keyProperties.add(propNew);
            } else {
                trueProperties.add(propNew);
            }
        }
        List<Property> props = new ArrayList<>();
        props.addAll(keyProperties);
        props.addAll(trueProperties);
        if(keyProperties.stream().map( p -> p.getName()).noneMatch(n -> n.equals("segment"))){
            keyProperties.add(new Property("segment","null"));
        }
        return new Entity(Entity.buildUniqueNameFromProperties(keyProperties),props);
    }

    protected List<Property> getTrueProperties() {
        return rawProperties.stream().map( prop -> extractTrueProperty(prop.getValue())).filter(p -> p.getName().equals("segment")).collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }
}
