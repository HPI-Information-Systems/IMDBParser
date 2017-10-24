package de.hpi.data_change.imdb.parsing.countries;

import de.hpi.data_change.data.Entity;
import de.hpi.data_change.imdb.data.Country;
import de.hpi.data_change.imdb.data.Rating;
import de.hpi.data_change.imdb.generated.countries.CountriesLexer;
import de.hpi.data_change.imdb.generated.countries.CountriesParser;
import de.hpi.data_change.imdb.generated.ratings.RatingsLexer;
import de.hpi.data_change.imdb.generated.ratings.RatingsParser;
import de.hpi.data_change.imdb.parsing.IMDBFileANTLRGeneratedParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeListener;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by Leon.Bornemann on 7/19/2017.
 */
public class CountriesFileParser extends IMDBFileANTLRGeneratedParser<CountriesParser,Country> {

    private CountriesAggregator listener;

    @Override
    protected Collection<Country> getResults() {
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
    protected CountriesParser initParser(TokenStream tokens) {
        return new CountriesParser(tokens);
    }

    @Override
    protected Lexer initLexer(CharStream input) {
        return new CountriesLexer(input);
    }

    @Override
    protected void initListener() {
        listener = new CountriesAggregator();
    }

    public List<Country> getCountries() {
        return listener.getResult();
    }
}
