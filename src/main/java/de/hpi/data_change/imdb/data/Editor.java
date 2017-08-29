package de.hpi.data_change.imdb.data;

import de.hpi.data_change.data.Entity;
import de.hpi.data_change.data.Property;

import java.util.Arrays;
import java.util.List;

public class Editor extends AbstractCreativePerson{

    public Editor(String name, List<String> workTitles) {
        super(name, workTitles);
    }

    @Override
    protected String getPersonType() {
        return "Editor";
    }
}
