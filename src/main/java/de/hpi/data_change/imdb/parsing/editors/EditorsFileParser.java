package de.hpi.data_change.imdb.parsing.editors;

import de.hpi.data_change.imdb.data.Editor;
import de.hpi.data_change.imdb.generated.editors.EditorsLexer;
import de.hpi.data_change.imdb.generated.editors.EditorsParser;
import de.hpi.data_change.imdb.parsing.IMDBFileANTLRGeneratedParser;
import de.hpi.data_change.imdb.parsing.IMDBFileParser;
import de.hpi.data_change.imdb.parsing.editors.EditorsAggregator;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeListener;

import java.util.Collection;

public class EditorsFileParser extends IMDBFileANTLRGeneratedParser<EditorsParser,Editor> {

    private EditorsAggregator listener;

    @Override
    protected Collection<Editor> getResults() {
        return listener.getResult();
    }

    @Override
    protected ParseTreeListener getListener() {
        return listener;
    }

    @Override
    protected ParseTree invokeStartRule(EditorsParser parser) {
        return parser.r();
    }

    @Override
    protected EditorsParser initParser(CommonTokenStream tokens) {
        return new EditorsParser(tokens);
    }

    @Override
    protected Lexer initLexer(CharStream input) {
        return new EditorsLexer(input);
    }

    @Override
    protected void initListener() {
        listener = new EditorsAggregator();
    }
}
