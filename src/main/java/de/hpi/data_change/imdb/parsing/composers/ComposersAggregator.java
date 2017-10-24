package de.hpi.data_change.imdb.parsing.composers;

import de.hpi.data_change.data.Entity;
import de.hpi.data_change.data.Pair;
import de.hpi.data_change.imdb.data.Composer;
import de.hpi.data_change.imdb.data.Editor;
import de.hpi.data_change.imdb.generated.composers.ComposersBaseListener;
import de.hpi.data_change.imdb.generated.composers.ComposersParser;
import de.hpi.data_change.imdb.parsing.TitleEndRecognizer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Leon.Bornemann on 7/19/2017.
 */
public class ComposersAggregator extends ComposersBaseListener {

    private List<String> curWorks = new ArrayList<>();
    private List<Composer> allComposers = new ArrayList<>();

    @Override public void exitComposerAndWork(ComposersParser.ComposerAndWorkContext ctx) {
        String name = ctx.getChild(0).getText();
        String editorName = ctx.getChild(0).getText();
        for(String work :curWorks){
            Pair<String, String> tokens = TitleEndRecognizer.splitAfterTitle(work);
            String title = tokens.getFirst();
            String additionalInfo = tokens.getSecond();
            allComposers.add(new Composer(name,title,additionalInfo));
        }
        curWorks = new ArrayList<>();curWorks = new ArrayList<>();
    }

    @Override public void exitWorkElement(ComposersParser.WorkElementContext ctx) {
        if(ctx.getChildCount()==3) {
            curWorks.add(ctx.getChild(1).getText());
        } else{
            assert(ctx.getChildCount()==2);
            curWorks.add(ctx.getChild(0).getText());
        }
    }

    public List<Composer> getResult() {
        return allComposers;
    }
}
