package de.hpi.data_change.imdb.parsing.editors;

import de.hpi.data_change.data.Entity;
import de.hpi.data_change.imdb.generated.editors.EditorsBaseListener;
import de.hpi.data_change.imdb.generated.editors.EditorsParser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EditorsAggregator extends EditorsBaseListener{

    private List<String> curWorks = new ArrayList<>();
    private List<Entity> moviesWithEditors = new ArrayList<>();

    @Override public void exitEditorAndWork(EditorsParser.EditorAndWorkContext ctx) {
        String editorName = ctx.getChild(0).getText();
        moviesWithEditors.addAll(curWorks.stream().map(title -> new Entity(title,"Editor",editorName)).collect(Collectors.toList()));
        curWorks = new ArrayList<>();
    }

    @Override public void exitWorkElement(EditorsParser.WorkElementContext ctx) {
        if(ctx.getChildCount()==3) {
            curWorks.add(ctx.getChild(1).getText());
        } else{
            assert(ctx.getChildCount()==2);
            curWorks.add(ctx.getChild(0).getText());
        }
    }

    public List<Entity> getResult() {
        return Entity.concatenateByKey(moviesWithEditors);
    }
}
