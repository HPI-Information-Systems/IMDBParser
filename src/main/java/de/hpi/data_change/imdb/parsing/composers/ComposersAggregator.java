package de.hpi.data_change.imdb.parsing.composers;

import de.hpi.data_change.imdb.data.Composer;
import de.hpi.data_change.imdb.data.Director;
import de.hpi.data_change.imdb.generated.composers.ComposersBaseListener;
import de.hpi.data_change.imdb.generated.composers.ComposersParser;
import de.hpi.data_change.imdb.generated.directors.DirectorsBaseListener;
import de.hpi.data_change.imdb.generated.directors.DirectorsParser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Leon.Bornemann on 7/19/2017.
 */
public class ComposersAggregator extends ComposersBaseListener {

    private List<String> curWorks = new ArrayList<>();
    private List<Composer> allComposers = new ArrayList<>();

    @Override public void exitComposerAndWork(ComposersParser.ComposerAndWorkContext ctx) {
        String name = ctx.getChild(0).getText();
        allComposers.add(new Composer(name,curWorks));
        curWorks = new ArrayList<>();
    }

    @Override public void exitWorkElement(ComposersParser.WorkElementContext ctx) {
        if(ctx.getChildCount()==3) {
            curWorks.add(ctx.getChild(1).getText());
        } else{
            if(ctx.getChildCount()!=2){
                System.err.println("Assertion error incoming - weird number of elements in parse tree");
                System.err.println("Starting line: " + ctx.start.getLine() + "  ending line: " + ctx.stop.getLine());
            }
            assert(ctx.getChildCount()==2);
            curWorks.add(ctx.getChild(0).getText());
        }
    }

    public List<Composer> getResult() {
        return allComposers;
    }
}
