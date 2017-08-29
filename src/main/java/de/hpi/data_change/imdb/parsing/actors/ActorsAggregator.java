package de.hpi.data_change.imdb.parsing.actors;

import de.hpi.data_change.imdb.data.Actor;
import de.hpi.data_change.imdb.generated.actors.ActorsBaseListener;
import de.hpi.data_change.imdb.generated.actors.ActorsParser;

import java.util.ArrayList;
import java.util.List;

public class ActorsAggregator extends ActorsBaseListener{

    private List<String> curWorks = new ArrayList<>();
    private List<Actor> actors = new ArrayList<>();

    @Override public void exitActorAndWork(ActorsParser.ActorAndWorkContext ctx) {
        String actorName = ctx.getChild(0).getText();
        actors.add(new Actor(actorName,curWorks));
        curWorks = new ArrayList<>();
    }

    @Override public void exitWorkElement(ActorsParser.WorkElementContext ctx) {
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

    public List<Actor> getResult() {
        return actors;
    }
}
