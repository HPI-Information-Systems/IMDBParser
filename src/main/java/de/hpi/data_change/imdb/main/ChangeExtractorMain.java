package de.hpi.data_change.imdb.main;

import de.hpi.data_change.imdb.change_extraction.ChangeExtractor;
import de.hpi.data_change.imdb.change_extraction.DiffExtractor;
import de.hpi.data_change.imdb.data.TableType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.lookup.MainMapLookup;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/***
 * Main Class to extract the IMDB history. Run without arguments to see usage. Only works on Linux as it uses the patch command
 */
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
            System.err.println("args[1] - the table Type to parse, supported values: " + Arrays.stream(TableType.values()).collect(Collectors.toList()));
            System.err.println("args[2] - the path to diff directory (diffs can be either in the compressed form or in text files (.list)");
            System.err.println("args[3] - the target directory for the changes");
            System.err.println("args[4] - a working directory to store temporary files");
            return;
        }
        File originalFile = new File(args[0]);
        logger.info("Started Change Extraction for " + originalFile.getName());
        List<File> diffFiles = DiffExtractor.getDiffFilesInDir(new File(args[2]));
        File targetDir = new File(args[3]);
        assert(originalFile.exists());
        assert(targetDir.isDirectory());
        targetDir.mkdirs();
        File workingDir;
        workingDir = new File(args[4]);
        TableType tableType = TableType.valueOf(args[1]);
        new ChangeExtractor(originalFile,diffFiles,targetDir,workingDir,tableType).extractChanges();
    }
}
