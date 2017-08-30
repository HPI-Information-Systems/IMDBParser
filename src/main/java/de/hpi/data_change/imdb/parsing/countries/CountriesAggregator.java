package de.hpi.data_change.imdb.parsing.countries;

import de.hpi.data_change.data.Entity;
import de.hpi.data_change.data.Property;
import de.hpi.data_change.imdb.generated.countries.CountriesBaseListener;
import de.hpi.data_change.imdb.generated.countries.CountriesParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Leon.Bornemann on 7/19/2017.
 */
public class CountriesAggregator extends CountriesBaseListener {

    private List<Entity> entities = new ArrayList<>();

    @Override public void exitCountry(CountriesParser.CountryContext ctx) {
        assert(ctx.getChildCount()==3);
        entities.add(new Entity(ctx.getChild(0).getText(), Arrays.asList(new Property("country",ctx.getChild(2).getText()))));
    }

    public List<Entity> getResult() {
        return entities;
    }
}
