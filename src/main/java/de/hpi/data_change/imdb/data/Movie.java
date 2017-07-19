package de.hpi.data_change.imdb.data;

import java.time.Year;
import java.util.List;

/**
 * Created by Leon.Bornemann on 7/18/2017.
 */
public class Movie extends Video{

    public Movie(String title, Year year, List<String> extraTokens) {
        super(title,year,extraTokens);
    }

    @Override
    protected VideoType getType() {
        return VideoType.Movie;
    }
}
