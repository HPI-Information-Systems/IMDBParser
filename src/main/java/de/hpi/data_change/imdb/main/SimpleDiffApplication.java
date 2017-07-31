package de.hpi.data_change.imdb.main;

import de.hpi.data_change.imdb.change_extraction.DiffApplyer;

import java.io.File;
import java.io.IOException;

public class SimpleDiffApplication {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Trying to execute simple diff command");
        File original = new File(args[0]);
        File diffFile = new File(args[1]);
        File targetFile = new File(args[2]);
        DiffApplyer applyer = new DiffApplyer();
        applyer.applyDiffForwards(original,diffFile,targetFile);
    }
}
