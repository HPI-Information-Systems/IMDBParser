package de.hpi.data_change.imdb.data;

import de.hpi.data_change.data.Property;

import java.util.Arrays;
import java.util.List;

public class Country extends MultiPropertyEntity{

    public Country(String name,String movieTitle,String additionalInfo) {
        super(Arrays.asList(new Property("name",name), new Property( "title",movieTitle)), additionalInfo);
    }
}
