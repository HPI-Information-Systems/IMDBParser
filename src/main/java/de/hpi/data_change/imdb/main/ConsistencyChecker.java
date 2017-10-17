package de.hpi.data_change.imdb.main;

import de.hpi.data_change.imdb.data.TableType;
import de.hpi.data_change.imdb.parsing.IMDBFileANTLRGeneratedParser;
import de.hpi.data_change.imdb.parsing.IMDBFileParser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ConsistencyChecker {
    public static void main(String[] args) throws IOException {
        File moviesFile = new File("/home/leon/Documents/researchProjects/imdb/database/movies.list");
        File toCheck = new File("/home/leon/Documents/researchProjects/imdb/database/actors.list");
        PrintWriter outInside = new PrintWriter(new FileWriter(new File("/home/leon/Documents/researchProjects/imdb/moviesFromActorsInMovies.txt")));
        PrintWriter outOutside = new PrintWriter(new FileWriter(new File("/home/leon/Documents/researchProjects/imdb/moviesFromActorsNotInMovies.txt")));
        IMDBFileParser moviesParser = IMDBFileANTLRGeneratedParser.createParser(TableType.Movies);
        IMDBFileParser directorsParser = IMDBFileANTLRGeneratedParser.createParser(TableType.Actor);
        moviesParser.parseText(moviesFile);
        Set<String> existing = moviesParser.getEntities().map(e -> e.getName()).collect(Collectors.toSet());
        directorsParser.parseText(toCheck);
        List<String> toCheckFor = directorsParser.getEntities().map(e -> e.getName()).collect(Collectors.toList());
        int count = 0;
        for(String title : toCheckFor){
            if(!existing.contains(title)){
                outOutside.println(title);
                count++;
            } else {
                outInside.println(title);
            }
        }
        System.out.println("in:" + existing.size());
        System.out.println("out:" + count);
    }
}
