package de.hpi.data_change.imdb.parsing.countries;

import de.hpi.data_change.data.Entity;
import de.hpi.data_change.imdb.data.Rating;
import de.hpi.data_change.imdb.generated.countries.CountriesParser;
import de.hpi.data_change.imdb.generated.ratings.RatingsLexer;
import de.hpi.data_change.imdb.generated.ratings.RatingsParser;
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
public class CountriesFileParser extends IMDBFileANTLRGeneratedParser<CountriesParser,Entity> {

    private CountriesAggregator listener;

    @Override
    protected Collection<Entity> getResults() {
        return listener.getResult();
    }

    @Override
    protected ParseTreeListener getListener() {
        return listener;
    }

    @Override
    protected ParseTree invokeStartRule(CountriesParser parser) {
        return parser.r();
    }

    @Override
    protected CountriesParser initParser(CommonTokenStream tokens) {
        return new CountriesParser(tokens);
    }

    @Override
    protected Lexer initLexer(CharStream input) {
        return new RatingsLexer(input);
    }

    @Override
    protected void initListener() {
        listener = new CountriesAggregator();
    }
}
