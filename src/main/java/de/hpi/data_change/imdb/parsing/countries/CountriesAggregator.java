package de.hpi.data_change.imdb.parsing.countries;

import de.hpi.data_change.data.Entity;
import de.hpi.data_change.data.Pair;
import de.hpi.data_change.imdb.data.Country;
import de.hpi.data_change.imdb.generated.countries.CountriesBaseListener;
import de.hpi.data_change.imdb.generated.countries.CountriesParser;
import de.hpi.data_change.imdb.parsing.TitleEndRecognizer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Leon.Bornemann on 7/19/2017.
 */
public class CountriesAggregator extends CountriesBaseListener {

    private List<Country> entities = new ArrayList<>();

    @Override public void exitCountry(CountriesParser.CountryContext ctx) {
        assert(ctx.getChildCount()==4);
        String title = ctx.getChild(0).getText();
        String countryName = ctx.getChild(2).getText();
        entities.add(new Country(countryName,title,""));
    }

    public List<Country> getResult() {
        return entities;
    }
}
