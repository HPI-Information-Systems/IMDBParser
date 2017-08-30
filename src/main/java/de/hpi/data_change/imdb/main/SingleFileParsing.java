package de.hpi.data_change.imdb.main;

import de.hpi.data_change.imdb.change_extraction.DiffApplyer;
import de.hpi.data_change.imdb.data.TableType;
import de.hpi.data_change.imdb.generated.ratings.TEstLexer;
import de.hpi.data_change.imdb.generated.ratings.TEstParser;
import de.hpi.data_change.imdb.parsing.IMDBFileANTLRGeneratedParser;
import de.hpi.data_change.imdb.parsing.IMDBFileParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;

import java.io.*;
import java.util.Arrays;
import java.util.stream.IntStream;

public class SingleFileParsing {

    public static void main(String[] args) throws IOException, InterruptedException {
        smalltest();
        //otherstuff();
        //actorstuff();
    }

    private static void smalltest() throws IOException {
        String input1 = "asd \r\n";
        StringReader reader = new StringReader(input1);
        CharStream input = CharStreams.fromReader(reader); // .fromString("hello parrt"); //.fromFileName(file.getAbsolutePath());
        Lexer lex = new TEstLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lex); // a token stream
        TEstParser parser = new TEstParser(tokens);
        parser.r();
    }

    private static void otherstuff() throws IOException {
        IMDBFileParser parser = IMDBFileANTLRGeneratedParser.createParser(TableType.Country);
        File src = new File("C:\\Users\\Leon.Bornemann\\Documents\\Database Changes\\Data\\IMDB\\Database\\countries.list\\new 1.txt");
        parser.parseText(src);
        parser.getEntities().limit(100).forEach(e -> System.out.println(e));
    }

    private static void actorstuff() throws IOException {
        System.out.println((int) '\n');
        System.out.println((int) '\r');
        System.out.println("Parsing single File");
        IMDBFileParser parser = IMDBFileANTLRGeneratedParser.createParser(TableType.Country);
        //File src = new File("C:\\Users\\Leon.Bornemann\\Documents\\Database Changes\\Data\\IMDB\\Database\\actresses.list\\actresses.list");
        File src = new File("C:\\Users\\Leon.Bornemann\\Documents\\Database Changes\\Data\\IMDB\\Database\\countries.list\\new 1.txt");
        BufferedReader br = new BufferedReader(new FileReader(src));
//        int lineNum = 1;
//        String line = br.readLine();
//        while(line != null){
//            if(lineNum <=500){
//                String myLine = line.chars().boxed().map(i -> i.toString()).reduce((c1, c2) -> c1 + ";" + c2).orElseGet(() ->"<empty line>");
//                System.out.println(line);
//                //System.out.println(myLine);
//                //System.out.println("--------------------------------------------end---------------------------------------------------");
//            }
//            line = br.readLine();
//            lineNum++;
//        }
        char[] buffer = new char[1024];
        br.read(buffer,0,1024);
        String res = IntStream.range(0, buffer.length).map(i -> buffer[i]).boxed()
                .map(i -> toLiteral((char) i.intValue()))
                .reduce((c1, c2) -> c1 + c2).get();
        System.out.println(res);
//
//        parser.parseText(src);
//        parser.getEntities().limit(100).forEach(e -> System.out.println(e));
    }

    private static String toLiteral(char c) {
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
            default:
                return new Character(c).toString();
        }
    }
}
