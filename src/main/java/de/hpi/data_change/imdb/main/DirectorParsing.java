package de.hpi.data_change.imdb.main;

import de.hpi.data_change.imdb.parsing.directors.DirectorsReader;

import java.io.File;
import java.io.IOException;

/**
 * Created by Leon.Bornemann on 7/19/2017.
 */
public class DirectorParsing {

    public static void main(String[] args) throws IOException {
        if(args.length==0){
            System.err.println("Application requires path to movies.list file as first parameter");
            System.err.println("Terminating");
            return;
        }
        DirectorsReader directorsReader = new DirectorsReader();
        directorsReader.parseGZ(new File(args[0]));
        //directorsReader.printResult();
    }
}
