package de.hpi.data_change.imdb.parsing.editors;

import de.hpi.data_change.data.Entity;
import de.hpi.data_change.data.Pair;
import de.hpi.data_change.imdb.data.Director;
import de.hpi.data_change.imdb.data.Editor;
import de.hpi.data_change.imdb.generated.editors.EditorsBaseListener;
import de.hpi.data_change.imdb.generated.editors.EditorsParser;
import de.hpi.data_change.imdb.parsing.TitleEndRecognizer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EditorsAggregator extends EditorsBaseListener{

    private List<String> curWorks = new ArrayList<>();
    private List<Editor> editors = new ArrayList<>();

    @Override public void exitEditorAndWork(EditorsParser.EditorAndWorkContext ctx) {
        String editorName = ctx.getChild(0).getText();
        for(String work :curWorks){
            Pair<String, String> tokens = TitleEndRecognizer.splitAfterTitle(work);
            String title = tokens.getFirst();
            String additionalInfo = tokens.getSecond();
            editors.add(new Editor(editorName,title,additionalInfo));
        }
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

    public List<Editor> getResult() {
        return editors;
    }
}
