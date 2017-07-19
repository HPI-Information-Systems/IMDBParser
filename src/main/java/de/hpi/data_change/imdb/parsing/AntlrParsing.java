package de.hpi.data_change.imdb.parsing;

import de.hpi.data_change.imdb.generated.directors.DirectorsParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.*;
import java.util.zip.GZIPInputStream;
import de.hpi.data_change.imdb.generated.directors.DirectorsLexer;

/**
 * Created by Leon.Bornemann on 7/19/2017.
 */
public class AntlrParsing {

    public static void main(String[] args) throws IOException {
        //new AntlrParsing().parseGZ(new File("X:\\HPI_Allgemein\\Arbeitsgruppen\\naumann\\Daten\\IMDB\\database\\directors.list.gz"));
        new AntlrParsing().parseText(new File("resources/testData/directorTest.txt"));
    }

    private void parseText(File file) throws IOException {
        parseInputStream(new FileInputStream(file));
    }

    public void parseGZ(File gzfile) throws IOException {
        GZIPInputStream is = new GZIPInputStream(new FileInputStream(gzfile));
        parseInputStream(is);
    }

    private void parseInputStream(InputStream is) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        CharStream input = CharStreams.fromReader(br); // .fromString("hello parrt"); //.fromFileName(file.getAbsolutePath());
        DirectorsLexer lex = new DirectorsLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lex); // a token stream
        DirectorsParser parser = new DirectorsParser(tokens); // transforms tokens into parse trees
        ParseTree t = parser.r(); // creates the parse tree from the called rule
    }

    /*
    ANTLRFileStream input = new ANTLRFileStream(fileName); // a character stream
JayLexer lex = new JayLexer(input); // transforms characters into tokens
CommonTokenStream tokens = new CommonTokenStream(lex); // a token stream
JayParser parser = new JayParser(tokens); // transforms tokens into parse trees
ParseTree t = parser.your_first_rule_name(); // creates the parse tree from the called rule
     */
}
