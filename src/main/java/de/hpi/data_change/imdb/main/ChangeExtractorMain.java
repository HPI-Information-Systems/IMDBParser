package de.hpi.data_change.imdb.main;

import de.hpi.data_change.imdb.change_extraction.ChangeExtractor;
import de.hpi.data_change.imdb.change_extraction.DiffExtractor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.lookup.MainMapLookup;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ChangeExtractorMain {

    static Logger logger;
    /**
     *
     * @param args args[0] path to original File originalFile, args[1] path to diff directory, args[2] change database target directory, args[3] optional, working Directory for the diffs
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        if(args.length>= 5) {
            MainMapLookup.setMainArguments(args);
            logger = LogManager.getLogger(ChangeExtractorMain.class);
        } else{
            System.err.println("Not enough parameters, please provide:");
            System.err.println("args[0] - the path to original File");
            System.err.println("args[1] - the path to diff directory (diffs can be either in the compressed form or in text files (.list)");
            System.err.println("args[2] - the target directory for the changes");
            System.err.println("args[3] - a working directory to store temporary files");
            System.err.println("args[4] - path to a log file");
            return;
        }
        logger.info("Started Change Extraction for IMDB Directors");
        File originalFile = new File(args[0]);
        List<File> diffFiles = DiffExtractor.getDiffFilesInDir(new File(args[1]));
        File targetDir = new File(args[2]);
        assert(originalFile.exists());
        assert(targetDir.isDirectory());
        targetDir.mkdirs();
        File workingDir;
        workingDir = new File(args[3]);
        new ChangeExtractor(originalFile,diffFiles,targetDir,workingDir).extractChanges();

    }
}
