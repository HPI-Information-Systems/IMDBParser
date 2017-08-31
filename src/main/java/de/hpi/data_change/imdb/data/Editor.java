package de.hpi.data_change.imdb.data;

import java.util.List;

public class Editor extends MultiPropertyEntity {

    public Editor(String name, List<String> workTitles) {
        super(name, workTitles);
    }

    @Override
    protected String getPersonType() {
        return "Editor";
    }
}
