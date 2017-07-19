package de.hpi.data_change.imdb.parsing;

import de.hpi.data_change.imdb.data.Video;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;

/**
 * Created by Leon.Bornemann on 7/18/2017.
 */
public class IMDBMovieListParser {

    private int beginCount = 11;
    private char beginChar = '=';
    private char endChar = '-';
    private int endCount = 20;

    private LexerState state = LexerState.FIND_START;
    private List<Video> movies = new ArrayList<>();
    private List<String> malFormattedLines = new ArrayList<>();

    public IMDBMovieListParser() {
    }

    public void parseFile(String fullPath) throws IOException {
        GZIPInputStream is = new GZIPInputStream(new FileInputStream(fullPath));
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
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
            movies.add(Video.createFromTokens(tokens[0],tokens[1],extraTokens));
        }
    }


    public void print() {
        movies.stream().limit(1000).forEach( m -> System.out.println(m));
        System.out.println("-------------------------------------------------------");
        System.out.println("Malformatted lines:");
        malFormattedLines.forEach(l -> System.out.println(l));
    }
}
