package de.hpi.data_change.imdb.parsing.locations;

import de.hpi.data_change.data.Entity;
import de.hpi.data_change.imdb.data.Location;
import de.hpi.data_change.imdb.data.Rating;
import de.hpi.data_change.imdb.generated.locations.LocationsLexer;
import de.hpi.data_change.imdb.generated.locations.LocationsParser;
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
public class LocationsFileParser extends IMDBFileANTLRGeneratedParser<LocationsParser,Location> {

    private LocationsAggregator listener;

    @Override
    protected Collection<Location> getResults() {
        return listener.getResult();
    }

    @Override
    protected ParseTreeListener getListener() {
        return listener;
    }

    @Override
    protected ParseTree invokeStartRule(LocationsParser parser) {
        return parser.r();
    }

    @Override
    protected LocationsParser initParser(CommonTokenStream tokens) {
        return new LocationsParser(tokens);
    }

    @Override
    protected Lexer initLexer(CharStream input) {
        return new LocationsLexer(input);
    }

    @Override
    protected void initListener() {
        listener = new LocationsAggregator();
    }
}
