package de.hpi.data_change.imdb.main;

import de.hpi.data_change.imdb.change_extraction.DiffExtractor;

import java.io.File;

public class DummyTestMain {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Leon.Bornemann\\Desktop\\playground\\IMDB\\Director Diffs Extracted");
        DiffExtractor.getDiffFilesInDir(file);
    }
}
