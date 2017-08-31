package de.hpi.data_change.imdb.parsing.locations;

import de.hpi.data_change.imdb.data.Location;
import de.hpi.data_change.imdb.data.Rating;
import de.hpi.data_change.imdb.generated.locations.LocationsBaseListener;
import de.hpi.data_change.imdb.generated.locations.LocationsParser;
import de.hpi.data_change.imdb.generated.ratings.RatingsBaseListener;
import de.hpi.data_change.imdb.generated.ratings.RatingsParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Leon.Bornemann on 7/19/2017.
 */
public class LocationsAggregator extends LocationsBaseListener {

    private List<String[]> ratings = new ArrayList<>();

    @Override public void exitLocation(LocationsParser.LocationContext ctx) {
        assert(ctx.getChildCount()==4);
        String[] pair = new String[] {ctx.getChild(0).getText(),ctx.getChild(2).getText()};
        ratings.add(pair);
    }

    public List<Location> getResult() {
        return null;
    }
}
