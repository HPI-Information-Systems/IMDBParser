package de.hpi.data_change.imdb.parsing.actors;

import de.hpi.data_change.data.Entity;
import de.hpi.data_change.imdb.data.Actor;
import de.hpi.data_change.imdb.generated.actors.ActorsLexer;
import de.hpi.data_change.imdb.generated.actors.ActorsParser;
import de.hpi.data_change.imdb.parsing.IMDBFileANTLRGeneratedParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeListener;

import java.util.Collection;

public class ActorsFileParser extends IMDBFileANTLRGeneratedParser<ActorsParser,Entity> {

    private ActorsAggregator listener;

    @Override
    protected Collection<Entity> getResults() {
        return listener.getResult();
    }

    @Override
    protected ParseTreeListener getListener() {
        return listener;
    }

    @Override
    protected ParseTree invokeStartRule(ActorsParser parser) {
        return parser.r();
    }

    @Override
    protected ActorsParser initParser(TokenStream tokens) {
        return new ActorsParser(tokens);
    }

    @Override
    protected Lexer initLexer(CharStream input) {
        return new ActorsLexer(input);
    }

    @Override
    protected void initListener() {
        this.listener = new ActorsAggregator();
    }
}
