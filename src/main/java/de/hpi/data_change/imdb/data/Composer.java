package de.hpi.data_change.imdb.data;

import de.hpi.data_change.data.Property;

import java.util.Arrays;

public class Composer extends MultiPropertyEntity{
    public Composer(String name, String title, String additionalInfo) {
        super(Arrays.asList(new Property("name",name), new Property( "title",title)), additionalInfo);
    }
}
