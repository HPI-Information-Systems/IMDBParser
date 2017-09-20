package de.hpi.data_change.imdb.parsing.countries;

import de.hpi.data_change.data.Entity;
import de.hpi.data_change.imdb.generated.countries.CountriesBaseListener;
import de.hpi.data_change.imdb.generated.countries.CountriesParser;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Leon.Bornemann on 7/19/2017.
 */
public class CountriesAggregator extends CountriesBaseListener {

    private List<Entity> entities = new ArrayList<>();

    @Override public void exitCountry(CountriesParser.CountryContext ctx) {
        assert(ctx.getChildCount()==4);
        String title = ctx.getChild(0).getText();
        String genre = ctx.getChild(2).getText();
        entities.add(new Entity(title,"Country",genre));
    }

    public List<Entity> getResult() {
        return Entity.concatenateByKey(entities);
    }
}
