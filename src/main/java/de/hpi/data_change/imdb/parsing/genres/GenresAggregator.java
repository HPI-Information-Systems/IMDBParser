package de.hpi.data_change.imdb.parsing.genres;

import de.hpi.data_change.data.Entity;
import de.hpi.data_change.data.Property;
import de.hpi.data_change.imdb.data.Genre;
import de.hpi.data_change.imdb.generated.countries.CountriesBaseListener;
import de.hpi.data_change.imdb.generated.countries.CountriesParser;
import de.hpi.data_change.imdb.generated.genres.GenresBaseListener;
import de.hpi.data_change.imdb.generated.genres.GenresParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Leon.Bornemann on 7/19/2017.
 */
public class GenresAggregator extends GenresBaseListener {

    private List<List<String>> entities = new ArrayList<List<String>>();

    @Override public void exitGenre(GenresParser.GenreContext ctx) {
        assert(ctx.getChildCount()==4);
        entities.add(Arrays.asList(ctx.getChild(0).getText(),ctx.getChild(2).getText()));
    }

    public List<Genre> getResult() {
        return entities.stream().collect(Collectors.groupingBy(list -> list.get(0)))
                .entrySet()
                .stream()
                .map( e -> new Genre(e.getKey(),e.getValue().stream().map(l -> l.get(1)).collect(Collectors.toList())))
                .collect(Collectors.toList());
    }

}
