package de.hpi.data_change.imdb.parsing.directors;

import de.hpi.data_change.imdb.data.Director;
import de.hpi.data_change.imdb.generated.directors.DirectorsBaseListener;
import de.hpi.data_change.imdb.generated.directors.DirectorsParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Leon.Bornemann on 7/19/2017.
 */
public class DirectorsAggregator extends DirectorsBaseListener {

    private List<String> curWorks = new ArrayList<>();
    private List<Director> allDirectors = new ArrayList<>();

    @Override public void exitDirectorAndWork(DirectorsParser.DirectorAndWorkContext ctx) {
        String directorName = ctx.getChild(0).getText();
        allDirectors.add(new Director(directorName,curWorks));
        curWorks = new ArrayList<>();
    }

    @Override public void exitWorkElement(DirectorsParser.WorkElementContext ctx) {
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

    public List<Director> getResult() {
        return allDirectors;
    }
}
