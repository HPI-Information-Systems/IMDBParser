package de.hpi.data_change.imdb.data.videos;

import de.hpi.data_change.data.Entity;
import de.hpi.data_change.data.Property;
import de.hpi.data_change.imdb.IOConstants;

import java.time.Year;
import java.util.Arrays;
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

    @Override
    public Entity toEntity() {
        return new Entity(title, Arrays.asList(new Property("date",year == null ? IOConstants.NULL_REPRESENTATION: year.toString())));
    }
}
