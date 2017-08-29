package de.hpi.data_change.imdb.parsing.movies;

import de.hpi.data_change.data.Entity;
import de.hpi.data_change.imdb.IOConstants;
import de.hpi.data_change.imdb.data.videos.Video;
import de.hpi.data_change.imdb.parsing.IMDBFileParser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.util.zip.GZIPInputStream;

/**
 * Created by Leon.Bornemann on 7/18/2017.
 * The only manually created Parser before I decided to use ANTLR to generate Parsers for the different files of IMDB.
 */
public class MovieFileParser implements IMDBFileParser {

    private int beginCount = 11;
    private char beginChar = '=';
    private char endChar = '-';
    private int endCount = 20;

    private LexerState state = LexerState.FIND_START;
    private List<Video> videos = new ArrayList<>();
    private List<String> malFormattedLines = new ArrayList<>();


    @Override
    public void parseGZ(File source) throws IOException {
        GZIPInputStream is = new GZIPInputStream(new FileInputStream(source));
        parseFile(is);
    }

    @Override
    public void parseText(File source) throws IOException {
        parseFile(new FileInputStream(source));
    }

    @Override
    public Stream<Entity> getEntities() {
       return  videos.stream().map(m -> m.toEntity());
    }

    public void parseFile(InputStream is) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(is, IOConstants.ENCODING)); //TODO: lets hope this is UTF8 - how do we determine that?
        String line = br.readLine();
        while(line !=null){
            processLine(line);
            line = br.readLine();
        }
    }

    private void processLine(String line) {
        if(state == LexerState.DONE){
            return;
        }
        if(state == LexerState.FIND_START){
            if(line.chars().allMatch(i -> i==beginChar) && line.chars().count()>=beginCount){
                state = LexerState.SKIPNEXT;
            }
            return;
        }
        if(state == LexerState.SKIPNEXT){
            state = LexerState.PARSEENTRY;
            return;
        }
        if(state == LexerState.PARSEENTRY){
            if(line.chars().allMatch(i -> i==endChar) && line.chars().count()>=endCount){
                state = LexerState.DONE;
                return;
            } else {
                parseVideo(line);
            }
        }
    }

    private void parseVideo(String line) {
        String[] tokens = line.split("\\t+");
        List<String> extraTokens = new ArrayList<>();
        for(int i=2;i<tokens.length;i++){
            extraTokens.add(tokens[i]);
        }
        if(tokens.length<2){
            malFormattedLines.add(line);
        } else {
            videos.add(Video.createFromTokens(tokens[0],tokens[1],extraTokens));
        }
    }


    public void print() {
        videos.stream().limit(1000).forEach(m -> System.out.println(m));
        System.out.println("-------------------------------------------------------");
        System.out.println("Malformatted lines:");
        malFormattedLines.forEach(l -> System.out.println(l));
    }
}
