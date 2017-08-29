package de.hpi.data_change.imdb.parsing.editors;

import de.hpi.data_change.imdb.data.Editor;
import de.hpi.data_change.imdb.generated.editors.EditorsBaseListener;
import de.hpi.data_change.imdb.generated.editors.EditorsParser;

import java.util.ArrayList;
import java.util.List;

public class EditorsAggregator extends EditorsBaseListener{
    private List<String> curWorks = new ArrayList<>();
    private List<Editor> allDirectors = new ArrayList<>();

    @Override public void exitEditorAndWork(EditorsParser.EditorAndWorkContext ctx) {
        String directorName = ctx.getChild(0).getText();
        allDirectors.add(new Editor(directorName,curWorks));
        curWorks = new ArrayList<>();
    }

    @Override public void exitWorkElement(EditorsParser.WorkElementContext ctx) {
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

    public List<Editor> getResult() {
        return allDirectors;
    }
}
