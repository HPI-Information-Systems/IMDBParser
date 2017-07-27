package de.hpi.data_change.imdb.parsing.directors;

import de.hpi.data_change.imdb.data.Director;
import de.hpi.data_change.imdb.generated.directors.DirectorsParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.*;
import java.util.List;
import java.util.zip.GZIPInputStream;
import de.hpi.data_change.imdb.generated.directors.DirectorsLexer;

/**
 * Created by Leon.Bornemann on 7/19/2017.
 */
public class DirectorsReader {

    private DirectorsAggregator listener = new DirectorsAggregator();


    public void parseText(File file) throws IOException {
        parseInputStream(new FileInputStream(file));
    }

    public void parseGZ(File gzfile) throws IOException {
        GZIPInputStream is = new GZIPInputStream(new FileInputStream(gzfile));
        parseInputStream(is);
    }

    private void parseInputStream(InputStream is) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF8")); //TODO: how do we know it is UTF8?
        CharStream input = CharStreams.fromReader(br); // .fromString("hello parrt"); //.fromFileName(file.getAbsolutePath());
        DirectorsLexer lex = new DirectorsLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lex); // a token stream
        DirectorsParser parser = new DirectorsParser(tokens); // transforms tokens into parse trees
        parser.addParseListener(listener);
        ParseTree t = parser.r(); // creates the parse tree from the called rule
    }

    public void printResult() {
        listener.getResult().forEach(d -> System.out.println(d));
    }

    public List<Director> getDirectors() {
        return listener.getResult();
    }

    /*
    ANTLRFileStream input = new ANTLRFileStream(fileName); // a character stream
JayLexer lex = new JayLexer(input); // transforms characters into tokens
CommonTokenStream tokens = new CommonTokenStream(lex); // a token stream
JayParser parser = new JayParser(tokens); // transforms tokens into parse trees
ParseTree t = parser.your_first_rule_name(); // creates the parse tree from the called rule
     */
}
