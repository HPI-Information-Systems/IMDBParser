package de.hpi.data_change.imdb.parsing.genres;

import de.hpi.data_change.data.Entity;
import de.hpi.data_change.imdb.data.Genre;
import de.hpi.data_change.imdb.generated.countries.CountriesLexer;
import de.hpi.data_change.imdb.generated.countries.CountriesParser;
import de.hpi.data_change.imdb.generated.genres.GenresLexer;
import de.hpi.data_change.imdb.generated.genres.GenresParser;
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
public class GenresFileParser extends IMDBFileANTLRGeneratedParser<GenresParser,Genre> {

    private GenresAggregator listener;

    @Override
    protected Collection<Genre> getResults() {
        return listener.getResult();
    }

    @Override
    protected ParseTreeListener getListener() {
        return listener;
    }

    @Override
    protected ParseTree invokeStartRule(GenresParser parser) {
        return parser.r();
    }

    @Override
    protected GenresParser initParser(CommonTokenStream tokens) {
        return new GenresParser(tokens);
    }

    @Override
    protected Lexer initLexer(CharStream input) {
        return new GenresLexer(input);
    }

    @Override
    protected void initListener() {
        listener = new GenresAggregator();
    }
}
