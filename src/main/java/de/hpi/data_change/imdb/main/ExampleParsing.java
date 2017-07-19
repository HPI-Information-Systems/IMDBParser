package de.hpi.data_change.imdb.main;

import java.io.IOException;

/**
 * Created by Leon.Bornemann on 7/18/2017.
 */
public class ExampleParsing {

    public static void main(String[] args) throws IOException {
        IMDBParser imdbParser = new IMDBParser();
        imdbParser.parseFile();
        imdbParser.print();
    }
}
