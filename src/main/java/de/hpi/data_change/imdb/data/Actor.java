package de.hpi.data_change.imdb.data;

import de.hpi.data_change.data.Entity;
import de.hpi.data_change.data.Property;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Actor extends MultiPropertyEntity {

    public Actor(String name, String movieTitle, String additionalInfo) {
        super(Arrays.asList(new Property("name",name), new Property( "title",movieTitle)), additionalInfo);
    }

    @Override
    protected List<Property> getTrueProperties() {
        List<Property> trueProperties = new ArrayList<>();
        for (Property prop : rawProperties) {
            switch (prop.getName()) {
                case "squareBracket_1":
                    trueProperties.add(new Property("role", prop.getValue()));
                    break;
                case "angularBracket_1":
                    trueProperties.add(new Property("positionInCredits", prop.getValue()));
                    break;
                default:
                    extractTrueProperty(prop.getValue());
            }
        }
        return trueProperties;
    }
}
