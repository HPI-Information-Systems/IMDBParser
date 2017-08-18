package de.hpi.data_change.imdb.parsing;

import de.hpi.data_change.data.Entity;
import de.hpi.data_change.imdb.data.TableType;
import de.hpi.data_change.imdb.parsing.directors.DirectorsFileParser;
import de.hpi.data_change.imdb.parsing.movies.MovieFileParser;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

public abstract class IMDBFileParser {

    public static IMDBFileParser createParser(TableType tableType) {
        switch(tableType){
            case Directors: return new DirectorsFileParser();
            case Movies: return new MovieFileParser();
            default: throw new AssertionError("unknown table type specified");
        }
    }

    public abstract void parseGZ(File source) throws IOException;

    public abstract void parseText(File source) throws IOException;

    public abstract Stream<Entity> getEntities();
}
