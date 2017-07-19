package de.hpi.data_change.imdb.main;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;

/**
 * Created by Leon.Bornemann on 7/18/2017.
 */
public class IMDBParser {

    private int beginCount = 11;
    private char beginChar = '=';
    private char endChar = '-';
    private int endCount = 20;

    private State state = State.FIND_START;
    private List<Video> movies = new ArrayList<>();
    private List<String> malFormattedLines = new ArrayList<>();

    public IMDBParser() {
    }

    public void parseFile() throws IOException {
        String filePath = "X:\\HPI_Allgemein\\Arbeitsgruppen\\naumann\\Daten\\IMDB\\database";
        String filename = "movies.list.gz";
        GZIPInputStream is = new GZIPInputStream(new FileInputStream(filePath + File.separator + filename));
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line = br.readLine();
        while(line !=null){
            processLine(line);
            line = br.readLine();
        }
    }

    private void processLine(String line) {
        if(state == State.DONE){
            return;
        }
        if(state == State.FIND_START){
            if(line.chars().allMatch(i -> i==beginChar) && line.chars().count()>=beginCount){
                state = State.SKIPNEXT;
            }
            return;
        }
        if(state == State.SKIPNEXT){
            state = State.PARSEMOVIE;
            return;
        }
        if(state == State.PARSEMOVIE){
            if(line.chars().allMatch(i -> i==endChar) && line.chars().count()>=endCount){
                state = State.DONE;
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
