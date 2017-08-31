package de.hpi.data_change.imdb.data;

import java.util.List;

public class Genre extends MultiPropertyEntity {

    public Genre(String name, List<String> workTitles) {
        super(name, workTitles);
    }

    @Override
    protected String getPersonType() {
        return "Genre";
    }

    @Override
    protected String getPropertyName() {
        return "genres";
    }
}
