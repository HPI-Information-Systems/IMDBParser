package de.hpi.data_change.imdb.data;

import de.hpi.data_change.data.Entity;
import de.hpi.data_change.data.Property;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Editor extends MultiPropertyEntity {

    public Editor(String name, String title, String additionalInfo) {
        super(Arrays.asList(new Property("name",name), new Property( "title",title)), additionalInfo);
    }
}
