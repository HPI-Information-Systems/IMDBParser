package de.hpi.data_change.imdb.main;

import de.hpi.data_change.imdb.change_extraction.ChangeExtractor;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ChangeExtractorMain {

    /**
     *
     * @param args args[0] = path to original File originalFile, args[1] path to diff directory, change database target directory
     */
    public static void main(String[] args) throws IOException {
        if(args.length<3){
            System.err.println("Not enough parameters, please provide the path to original File and the path to diff directory, the target directory for the changes");
            System.err.println("Optional fourth parameter is a directory to be used for temporary storage into which the diff files will be extracted. If omitted a temporary directory will be used");
        }
        File originalFile = new File(args[0]);
        List<File> diffFiles = Arrays.asList(new File(args[1]).listFiles((f, fname) ->fname.startsWith("diff") && fname.endsWith(".tar.gz")));
        File targetDir = new File(args[2]);
        assert(originalFile.exists());
        assert(targetDir.isDirectory());
        targetDir.mkdirs();
        File workingDir;
        if(args.length==4) {
            workingDir = new File(args[3]);
            new ChangeExtractor(originalFile,diffFiles,targetDir,workingDir).extractChanges();
        } else{
            new ChangeExtractor(originalFile,diffFiles,targetDir).extractChanges();
        }
    }
}
