package de.hpi.data_change.imdb.parsing.locations;

import de.hpi.data_change.imdb.IOConstants;
import de.hpi.data_change.imdb.data.Location;
import de.hpi.data_change.imdb.data.Rating;
import de.hpi.data_change.imdb.generated.locations.LocationsBaseListener;
import de.hpi.data_change.imdb.generated.locations.LocationsParser;
import de.hpi.data_change.imdb.generated.ratings.RatingsBaseListener;
import de.hpi.data_change.imdb.generated.ratings.RatingsParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Leon.Bornemann on 7/19/2017.
 */
public class LocationsAggregator extends LocationsBaseListener {

    private List<List<String>> pairs = new ArrayList<>();

    @Override public void exitLocation(LocationsParser.LocationContext ctx) {
        assert(ctx.getChildCount()>=4);
        List<String> triple = new ArrayList<>(Arrays.asList(ctx.getChild(0).getText(), ctx.getChild(2).getText()));

        if(ctx.getChildCount()!=4) {
            triple.add(ctx.getChild(4).getText());
            assert(ctx.getChildCount()==6);
        } else{
            assert ctx.getChildCount() == 4;
            triple.add(IOConstants.NULL_REPRESENTATION);
        }
        pairs.add(triple);
    }

    public List<Location> getResult() {
        return pairs.stream().collect(Collectors.groupingBy(list -> list.get(0)))
                .entrySet()
                .stream()
                .map( e -> toLocation(e))
                .collect(Collectors.toList());
    }

    private Location toLocation(Map.Entry<String, List<List<String>>> e) {
        String title = e.getKey();
        List<List<String>> allvals = e.getValue().stream().map(l -> l.subList(1, l.size())).collect(Collectors.toList());
        return new Location(title,allvals);

    }
}
