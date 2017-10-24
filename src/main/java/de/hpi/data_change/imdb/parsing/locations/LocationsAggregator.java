package de.hpi.data_change.imdb.parsing.locations;

import de.hpi.data_change.data.Entity;
import de.hpi.data_change.data.Property;
import de.hpi.data_change.imdb.data.Location;
import de.hpi.data_change.imdb.generated.locations.LocationsBaseListener;
import de.hpi.data_change.imdb.generated.locations.LocationsParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Leon.Bornemann on 7/19/2017.
 */
public class LocationsAggregator extends LocationsBaseListener {

    private List<Location> moviesWithLocation = new ArrayList<>();

    @Override public void exitLocation(LocationsParser.LocationContext ctx) {
        assert(ctx.getChildCount()>=4);
        List<String> triple = new ArrayList<>(Arrays.asList(ctx.getChild(0).getText(), ctx.getChild(2).getText()));
        String title = ctx.getChild(0).getText();
        String name = ctx.getChild(2).getText();
        String additionalInfo = "";
        if(ctx.getChildCount()!=4) {
           additionalInfo = ctx.getChild(4).getText();
            assert(ctx.getChildCount()==6);
        }
        moviesWithLocation.add(new Location(name,title,additionalInfo));
    }

    public List<Location> getResult() {
        return moviesWithLocation;
    }
}
