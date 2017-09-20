package de.hpi.data_change.imdb.parsing.editors;

import de.hpi.data_change.data.Entity;
import de.hpi.data_change.imdb.generated.editors.EditorsLexer;
import de.hpi.data_change.imdb.generated.editors.EditorsParser;
import de.hpi.data_change.imdb.parsing.IMDBFileANTLRGeneratedParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeListener;

import java.util.Collection;

public class EditorsFileParser extends IMDBFileANTLRGeneratedParser<EditorsParser,Entity> {

    private EditorsAggregator listener;

    @Override
    protected Collection<Entity> getResults() {
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
    protected EditorsParser initParser(TokenStream tokens) {
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
