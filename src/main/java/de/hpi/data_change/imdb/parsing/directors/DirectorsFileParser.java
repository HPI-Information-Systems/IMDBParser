package de.hpi.data_change.imdb.parsing.directors;

import de.hpi.data_change.data.Entity;
import de.hpi.data_change.imdb.data.Director;
import de.hpi.data_change.imdb.parsing.IMDBFileANTLRGeneratedParser;
import de.hpi.data_change.imdb.generated.directors.DirectorsParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.Collection;
import java.util.List;

import de.hpi.data_change.imdb.generated.directors.DirectorsLexer;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * Created by Leon.Bornemann on 7/19/2017.
 */
public class DirectorsFileParser extends IMDBFileANTLRGeneratedParser<DirectorsParser,Director> {

    private DirectorsAggregator listener;


    @Override
    protected Collection<Director> getResults() {
        return listener.getResult();
    }

    public List<Director> getDirectors(){ return listener.getResult();};

    @Override
    protected ParseTreeListener getListener() {
        return listener;
    }

    @Override
    protected ParseTree invokeStartRule(DirectorsParser parser) {
        return parser.r();
    }

    @Override
    protected DirectorsParser initParser(TokenStream tokens) {
        return new DirectorsParser(tokens);
    }

    @Override
    protected Lexer initLexer(CharStream input) {
        return new DirectorsLexer(input);
    }

    @Override
    protected void initListener() {
        listener = new DirectorsAggregator();
    }
}
