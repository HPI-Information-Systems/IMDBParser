package de.hpi.data_change.imdb.parsing.composers;

import de.hpi.data_change.imdb.data.Composer;
import de.hpi.data_change.imdb.generated.composers.ComposersParser;
import de.hpi.data_change.imdb.generated.directors.DirectorsLexer;
import de.hpi.data_change.imdb.parsing.IMDBFileANTLRGeneratedParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeListener;

import java.util.Collection;

/**
 * Created by Leon.Bornemann on 7/19/2017.
 */
public class ComposersFileParser extends IMDBFileANTLRGeneratedParser<ComposersParser,Composer> {

    private ComposersAggregator listener;


    @Override
    protected Collection<Composer> getResults() {
        return listener.getResult();
    }

    @Override
    protected ParseTreeListener getListener() {
        return listener;
    }

    @Override
    protected ParseTree invokeStartRule(ComposersParser parser) {
        return parser.r();
    }

    @Override
    protected ComposersParser initParser(CommonTokenStream tokens) {
        return new ComposersParser(tokens);
    }

    @Override
    protected Lexer initLexer(CharStream input) {
        return new DirectorsLexer(input);
    }

    @Override
    protected void initListener() {
        listener = new ComposersAggregator();
    }
}
