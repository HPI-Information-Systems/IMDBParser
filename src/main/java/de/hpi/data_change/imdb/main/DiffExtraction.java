package de.hpi.data_change.imdb.main;

import de.hpi.data_change.imdb.change_extraction.DiffExtractor;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class DiffExtraction {

    /***
     *
     * @param args usage: args[0] the directory containing the diff archives, args[1] the original file, for which the diffs should be extracted, args[2] the target directory
     */
    public static void main(String[] args) throws IOException {
        if(args.length<3){
            System.err.println("Missing arguments, please provide the directory containing the diff archives, the original file, for which the diffs should be extracted, and the target directory to extract the diffs into");
            return;
        }
        List<File> diffFiles = DiffExtractor.getDiffFilesInDir(new File(args[0]));
        String originalFilename = new File(args[1]).getName();
        File targetDir = new File(args[2]);
        DiffExtractor extractor = new DiffExtractor();
        extractor.extractDiffFiles(diffFiles,originalFilename,targetDir);
    }
}
