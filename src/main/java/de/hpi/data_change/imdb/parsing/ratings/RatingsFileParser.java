package de.hpi.data_change.imdb.parsing.ratings;

import de.hpi.data_change.imdb.data.Rating;
import de.hpi.data_change.imdb.generated.ratings.RatingsLexer;
import de.hpi.data_change.imdb.generated.ratings.RatingsParser;
import de.hpi.data_change.imdb.parsing.IMDBFileANTLRGeneratedParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeListener;

import java.util.Collection;

/**
 * Created by Leon.Bornemann on 7/19/2017.
 */
public class RatingsFileParser extends IMDBFileANTLRGeneratedParser<RatingsParser,Rating> {

    private RatingsAggregator listener;

    @Override
    protected Collection<Rating> getResults() {
        return listener.getResult();
    }

    @Override
    protected ParseTreeListener getListener() {
        return listener;
    }

    @Override
    protected ParseTree invokeStartRule(RatingsParser parser) {
        return parser.r();
    }

    @Override
    protected RatingsParser initParser(TokenStream tokens) {
        return new RatingsParser(tokens);
    }

    @Override
    protected Lexer initLexer(CharStream input) {
        return new RatingsLexer(input);
    }

    @Override
    protected void initListener() {
        listener = new RatingsAggregator();
    }
}
