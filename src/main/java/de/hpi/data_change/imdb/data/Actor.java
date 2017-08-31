package de.hpi.data_change.imdb.data;

import java.util.List;

public class Actor extends MultiPropertyEntity {

    public Actor(String name, List<String> workTitles) {
        super(name, workTitles);
    }

    @Override
    protected String getPersonType() {
        return "Actor";
    }
}
