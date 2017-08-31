package de.hpi.data_change.imdb.data;

import java.util.List;

public class Composer extends MultiPropertyEntity {

    public Composer(String name, List<String> workTitles) {
        super(name, workTitles);
    }

    @Override
    protected String getPersonType() {
        return "Composer";
    }
}
