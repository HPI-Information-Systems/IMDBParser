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
import de.hpi.data_change.imdb.parsing.locations.LocationsFileParser;
import de.hpi.data_change.imdb.parsing.genres.GenresFileParser;
import de.hpi.data_change.imdb.parsing.movies.MovieFileParser;
import de.hpi.data_change.imdb.parsing.ratings.RatingsFileParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeListener;

import java.io.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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
            case Location: return new LocationsFileParser();
            case Composer: return new ComposersFileParser();
            case Country: return new CountriesFileParser();
            case Genre: return new GenresFileParser();
            default: throw new AssertionError("unknown table type specified");
        }
    }

    public void parseText(File file) throws IOException {
        String encoding = IOConstants.getEncodingFromFileHeader(file);
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

        InputStreamReader br = new InputStreamReader(is,IOConstants.ENCODING); //TODO: how do we know it is UTF8?
        //StringReader br = new StringReader("\r\nasd\r\n");
        //doDebugStuff();
        //StringReader br = new StringReader(new String(buffer));
        CharStream input = CharStreams.fromReader(br); // .fromString("hello parrt"); //.fromFileName(file.getAbsolutePath());
        Lexer lex = initLexer(input);
        //CommonTokenStream tokens = new CommonTokenStream(lex); // a token stream
        CommonTokenStream tokens = new CommonTokenStream(lex);
        //doMoreDebugStuff(lex, tokens);
        T parser = initParser(tokens); // transforms tokens into parse trees
        //parser.setBuildParseTree(false);
        parser.addParseListener(getListener());
        ParseTree t = invokeStartRule(parser); // creates the parse tree from the called rule
    }

    private void doMoreDebugStuff(Lexer lex, CommonTokenStream tokens) {
        tokens.fill();
        List<Token> allToks = tokens.getTokens();
        List<String> tokContents = allToks.stream().limit(3000).map(t -> toLiteralString(t.getText())).collect(Collectors.toList());
        List<String> tokNames = allToks.stream().limit(3000).map(t -> lex.getVocabulary().getDisplayName(t.getType())).collect(Collectors.toList());
        IntStream.range(0,tokContents.size()).forEachOrdered(i -> System.out.println(tokNames.get(i) + ":" +tokContents.get(i)));
    }

    private void doDebugStuff() throws IOException {
        File src = new File("/home/leon/Documents/researchProjects/imdb/database/actresses.list");
        InputStreamReader br1 = new InputStreamReader(new FileInputStream(src));
        char[] buffer = new char[102400];
        br1.read(buffer,0,102400);
        int lineCount = 1;
        for(int i=0;i< buffer.length;i++){
            if(buffer[i]=='\n') lineCount++;
//            if(buffer[i] == '\r' || buffer[i] == '\n'){
//                System.out.println("found something");
//            }
            if(lineCount == 241){
                lineCount = 241;
            }
            System.out.println( (int) buffer[i] + "  " +buffer[i]);
        }
    }

    private boolean last4wereHyphon(char[] buffer, int i) {
        if(i<5) return false;
        return buffer[i-1] == '-' && buffer[i-2] == '-' && buffer[i-3] == '-' && buffer[i-4] == '-' && buffer[i-5] == '\n';
    }

    private String toLiteralString(String text) {
        return text.chars().boxed().map(c -> toLiteral(c.intValue())).reduce( (s1,s2) -> s1+s2).get();
    }

    private static String toLiteral(int c) {
        switch (c) {
            case '\n':
                return "\\n";
            case '\t':
                return "\\t";
            case '\r':
                return "\\r";
            case '\f':
                return "\\f";
            case '\b':
                return "\\b";
            case '\'':
                return "\\\'";
            case '\"':
                return "\\\"";
            case '\\':
                return "\\\\";
            case ' ':
                return "\\s";
            default:
                return new String(Character.toChars(c));
        }
    }

    protected abstract ParseTreeListener getListener();

    protected abstract ParseTree invokeStartRule(T parser);

    protected abstract T initParser(TokenStream tokens);

    protected abstract Lexer initLexer(CharStream input);

    protected abstract void initListener();
}
