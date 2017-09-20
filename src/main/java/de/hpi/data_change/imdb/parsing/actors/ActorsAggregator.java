package de.hpi.data_change.imdb.parsing.actors;

import de.hpi.data_change.data.Entity;
import de.hpi.data_change.imdb.data.Actor;
import de.hpi.data_change.imdb.generated.actors.ActorsBaseListener;
import de.hpi.data_change.imdb.generated.actors.ActorsParser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ActorsAggregator extends ActorsBaseListener {

    private List<String> curWorks = new ArrayList<>();
    private List<Entity> moviesWithActors = new ArrayList<>();

    @Override public void exitActorAndWork(ActorsParser.ActorAndWorkContext ctx) {
        String name = ctx.getChild(0).getText();
        moviesWithActors.addAll(curWorks.stream().map(title -> new Entity(title,"Actor",name)).collect(Collectors.toList()));
        curWorks = new ArrayList<>();
    }

    @Override public void exitWorkElement(ActorsParser.WorkElementContext ctx) {
        if(ctx.getChildCount()==3) {
            curWorks.add(ctx.getChild(1).getText());
        } else{
            assert(ctx.getChildCount()==2);
            curWorks.add(ctx.getChild(0).getText());
        }
    }

    public List<Entity> getResult() {
        return Entity.concatenateByKey(moviesWithActors);
    }
}
