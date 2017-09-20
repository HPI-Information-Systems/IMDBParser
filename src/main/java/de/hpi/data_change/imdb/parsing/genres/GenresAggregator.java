package de.hpi.data_change.imdb.parsing.genres;

import de.hpi.data_change.data.Entity;
import de.hpi.data_change.imdb.generated.genres.GenresBaseListener;
import de.hpi.data_change.imdb.generated.genres.GenresParser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Leon.Bornemann on 7/19/2017.
 */
public class GenresAggregator extends GenresBaseListener {

    private List<Entity> entities = new ArrayList<>();

    @Override public void exitGenre(GenresParser.GenreContext ctx) {
        assert(ctx.getChildCount()==4);
        String title = ctx.getChild(0).getText();
        String genre = ctx.getChild(2).getText();
        entities.add(new Entity(title,"Genre",genre));
    }

    public List<Entity> getResult() {
        return Entity.concatenateByKey(entities);
    }

}
