package de.hpi.data_change.imdb.data;

import java.util.List;

/**
 * Created by Leon.Bornemann on 7/19/2017.
 */
public class Director extends MultiPropertyEntity {

    public Director(String name, List<String> workTitles) {
        super(name, workTitles);
    }

    @Override
    protected String getPersonType() {
        return "Director";
    }
}
