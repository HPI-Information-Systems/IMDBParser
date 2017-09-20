package de.hpi.data_change.imdb.parsing.ratings;

import de.hpi.data_change.imdb.data.Rating;
import de.hpi.data_change.imdb.generated.ratings.RatingsBaseListener;
import de.hpi.data_change.imdb.generated.ratings.RatingsParser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Leon.Bornemann on 7/19/2017.
 */
public class RatingsAggregator extends RatingsBaseListener {

    private List<Rating> ratings = new ArrayList<>();

    @Override public void exitRating(RatingsParser.RatingContext ctx) {
        String new_ = null;
        int offset = 0;
        if(ctx.getChildCount() == 11){
            new_ = ctx.getChild(1).getText();
            offset = 2;
        } else if(ctx.getChildCount()==10 && ctx.getChild(0) instanceof RatingsParser.New_Context){
            new_ = ctx.getChild(0).getText();
            offset = 1;
        }
        //distribution:
        assert(ctx.getChild(offset+1) instanceof RatingsParser.DistributionContext);
        String distribution = ctx.getChild(offset + 1).getText();
        //votes:
        assert(ctx.getChild(offset+3) instanceof RatingsParser.VotesContext);
        int votes = Integer.parseInt(ctx.getChild(offset + 3).getText());
        //rank:
        assert(ctx.getChild(offset+5) instanceof RatingsParser.RankContext);
        float rank = Float.parseFloat(ctx.getChild(offset + 5).getText());
        //title:
        assert(ctx.getChild(offset+7) instanceof RatingsParser.TitleContext);
        String title = ctx.getChild(offset + 7).getText();
        ratings.add(new Rating(new_,distribution,votes,rank,title));
    }

    public List<Rating> getResult() {
        return ratings;
    }
}
