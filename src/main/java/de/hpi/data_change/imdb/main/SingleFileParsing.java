package de.hpi.data_change.imdb.main;

import de.hpi.data_change.imdb.IOConstants;
import de.hpi.data_change.imdb.change_extraction.DiffApplyer;
import de.hpi.data_change.imdb.data.TableType;
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
        locationStuff();
        //File src = new File("C:\\Users\\Leon.Bornemann\\Documents\\Database Changes\\Data\\IMDB\\Database\\genres.list\\genres.list");
        //File src = new File("C:\\Users\\Leon.Bornemann\\Documents\\Database Changes\\Data\\IMDB\\Database\\actresses.list\\actresses.list");
        //System.out.println(IOConstants.getEncodingFromFileHeader(src));
        //otherstuff();
        //actorstuff();
        //genrestuff();
    }

    private static void locationStuff() throws IOException {

        File src = new File("/home/leon/Documents/data/imdb/database/locations.list");
        IMDBFileParser parser = IMDBFileANTLRGeneratedParser.createParser(TableType.Location);
        parser.parseText(src);
        parser.getEntities().limit(100).forEach(e -> System.out.println(e));
    }

    private static void genrestuff() throws IOException {
        IMDBFileParser parser = IMDBFileANTLRGeneratedParser.createParser(TableType.Genre);
        File src = new File("C:\\Users\\Leon.Bornemann\\Documents\\Database Changes\\Data\\IMDB\\Database\\genres.list\\genres.list");
        parser.parseText(src);
        parser.getEntities().limit(100).forEach(e -> System.out.println(e));
    }


    private static void otherstuff() throws IOException {
        IMDBFileParser parser = IMDBFileANTLRGeneratedParser.createParser(TableType.Country);
        File src = new File("C:\\Users\\Leon.Bornemann\\Documents\\Database Changes\\Data\\IMDB\\Database\\countries.list\\countries.list");
        parser.parseText(src);
        parser.getEntities().limit(100).forEach(e -> System.out.println(e));
    }

    private static void actorstuff() throws IOException {
        System.out.println("Parsing single File");
        IMDBFileParser parser = IMDBFileANTLRGeneratedParser.createParser(TableType.Actress);
        //File src = new File("C:\\Users\\Leon.Bornemann\\Documents\\Database Changes\\Data\\IMDB\\Database\\actresses.list\\actresses.list");
        File src = new File("C:\\Users\\Leon.Bornemann\\Documents\\Database Changes\\Data\\IMDB\\Database\\actresses.list\\test.txt");
        //printstuff1(src);
        //printStuff2(src);

        parser.parseText(src);
        parser.getEntities().limit(100).forEach(e -> System.out.println(e));
    }

    private static void printStuff2(File src) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(src), IOConstants.ENCODING));
        char[] buffer = new char[102400];
        br.read(buffer,0,102400);
        String res = IntStream.range(0, buffer.length).map(i -> buffer[i]).boxed()
                .map(i -> toLiteral((char) i.intValue()))
                .reduce((c1, c2) -> c1 + c2).get();
        System.out.println(res);
        br.close();
    }

    private static void printstuff1(File src) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(src), IOConstants.ENCODING));
        int lineNum = 1;
        String line = br.readLine();
        while(line != null){
            if(lineNum <=700){
                String myLine = line.chars().boxed().map(i -> toLiteral(i).toString()).reduce((c1, c2) -> c1 + c2).orElseGet(() ->"<empty line>");
                System.out.println(line);
                System.out.println(myLine);
                System.out.println("--------------------------------------------end---------------------------------------------------");
            }
            line = br.readLine();
            lineNum++;
        }
        br.close();
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
}
