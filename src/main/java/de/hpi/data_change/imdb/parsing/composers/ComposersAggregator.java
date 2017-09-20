package de.hpi.data_change.imdb.parsing.composers;

import de.hpi.data_change.data.Entity;
import de.hpi.data_change.imdb.generated.composers.ComposersBaseListener;
import de.hpi.data_change.imdb.generated.composers.ComposersParser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Leon.Bornemann on 7/19/2017.
 */
public class ComposersAggregator extends ComposersBaseListener {

    private List<String> curWorks = new ArrayList<>();
    private List<Entity> allComposers = new ArrayList<>();

    @Override public void exitComposerAndWork(ComposersParser.ComposerAndWorkContext ctx) {
        String name = ctx.getChild(0).getText();
        allComposers.addAll(curWorks.stream().map(title -> new Entity(title,"Composer",name)).collect(Collectors.toList()));
        curWorks = new ArrayList<>();
    }

    @Override public void exitWorkElement(ComposersParser.WorkElementContext ctx) {
        if(ctx.getChildCount()==3) {
            curWorks.add(ctx.getChild(1).getText());
        } else{
            assert(ctx.getChildCount()==2);
            curWorks.add(ctx.getChild(0).getText());
        }
    }

    public List<Entity> getResult() {
        return Entity.concatenateByKey(allComposers);
    }
}
