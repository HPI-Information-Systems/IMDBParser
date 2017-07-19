package de.hpi.data_change.imdb.main;

import java.io.File;
import java.io.IOException;

/**
 * Created by Leon.Bornemann on 7/18/2017.
 */
public class ExampleParsing {

    public static void main(String[] args) throws IOException {
        if(args.length==0){
            System.err.println("Application requires path to movies.list file as first parameter");
            System.err.println("Terminating");
            return;
        }
        IMDBParser imdbParser = new IMDBParser();
        String fullPath = args[0];
        imdbParser.parseFile(fullPath);
        imdbParser.print();
    }
}