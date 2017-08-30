package de.hpi.data_change.imdb.parsing;

import de.hpi.data_change.data.Entity;
import de.hpi.data_change.imdb.IOConstants;
import de.hpi.data_change.imdb.data.CustomEntity;
import de.hpi.data_change.imdb.data.TableType;
import de.hpi.data_change.imdb.parsing.actors.ActorsFileParser;
import de.hpi.data_change.imdb.parsing.composers.ComposersFileParser;
import de.hpi.data_change.imdb.parsing.countries.CountriesFileParser;
import de.hpi.data_change.imdb.parsing.directors.DirectorsFileParser;
import de.hpi.data_change.imdb.parsing.editors.EditorsFileParser;
import de.hpi.data_change.imdb.parsing.movies.MovieFileParser;
import de.hpi.data_change.imdb.parsing.ratings.RatingsFileParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeListener;

import java.io.*;
import java.util.Collection;
import java.util.stream.Stream;
import java.util.zip.GZIPInputStream;

public abstract class IMDBFileANTLRGeneratedParser<T extends Parser,L extends CustomEntity> implements IMDBFileParser{

    public static IMDBFileParser createParser(TableType tableType) {
        switch(tableType){
            case Directors: return new DirectorsFileParser();
            case Movies: return new MovieFileParser();
            case Ratings: return new RatingsFileParser();
            case Editors: return new EditorsFileParser();
            case Actor: return new ActorsFileParser();
            case Actress: return new ActorsFileParser();
            case Composer: return new ComposersFileParser();
            case Country: return new CountriesFileParser();
            default: throw new AssertionError("unknown table type specified");
        }
    }

    public void parseText(File file) throws IOException {
        parseInputStream(new FileInputStream(file));
    }

    public Stream<Entity> getEntities() {
        return getResults().stream().map(d -> d.toEntity());
    }

    protected abstract Collection<L> getResults();

    public void parseGZ(File gzfile) throws IOException {
        GZIPInputStream is = new GZIPInputStream(new FileInputStream(gzfile));
        parseInputStream(is);
    }

    private void parseInputStream(InputStream is) throws IOException {
        initListener();
        BufferedReader br = new BufferedReader(new InputStreamReader(is, IOConstants.ENCODING)); //TODO: how do we know it is UTF8?
        CharStream input = CharStreams.fromReader(br); // .fromString("hello parrt"); //.fromFileName(file.getAbsolutePath());
        Lexer lex = initLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lex); // a token stream
        T parser = initParser(tokens); // transforms tokens into parse trees
        parser.addParseListener(getListener());
        ParseTree t = invokeStartRule(parser); // creates the parse tree from the called rule
    }

    protected abstract ParseTreeListener getListener();

    protected abstract ParseTree invokeStartRule(T parser);

    protected abstract T initParser(CommonTokenStream tokens);

    protected abstract Lexer initLexer(CharStream input);

    protected abstract void initListener();
}
