package de.hpi.data_change.imdb.main;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;
import org.apache.commons.compress.utils.IOUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Leon.Bornemann on 7/21/2017.
 */
public class ChangeExtractor {

    /**
     *
     * @param args args[0] = path to original File originalFile, args[1] path to diff directory, change database target directory
     */
    public static void main(String[] args) throws IOException {
        if(args.length<3){
            System.err.println("Not enough parameters, please provide the path to original File and the path to diff directory");
        }
        File originalFile = new File(args[0]);
        List<File> diffFiles = Arrays.asList(new File(args[1]).listFiles((f,fname) ->fname.startsWith("diff") && fname.endsWith(".tar.gz")));
        File targetDir = new File(args[2]);
        assert(originalFile.exists());
        assert(targetDir.isDirectory());
        targetDir.mkdirs();
        new ChangeExtractor(originalFile,diffFiles,targetDir).extractChanges();
    }

    private final File targetDir;
    private final List<File> diffFiles;
    private final File originalFile;

    public ChangeExtractor(File originalFile, List<File> diffFiles, File targetDir) {
        this.originalFile = originalFile;
        this.diffFiles = diffFiles;
        this.targetDir = targetDir;
    }

    private void extractChanges() throws IOException {
        String entityType = originalFile.getName().split("\\.")[0];
        File tempDir = Files.createTempDirectory("temporary").toFile();
        System.out.println("created temporary directory: " + tempDir.getAbsolutePath());
        tempDir.deleteOnExit();
        for(File tarGzFile : diffFiles) {
            System.out.println("processing " + tarGzFile.getName());
            TarArchiveInputStream tarInput = new TarArchiveInputStream(new GzipCompressorInputStream(new FileInputStream(tarGzFile)));
            TarArchiveEntry curEntry = tarInput.getNextTarEntry();
            while(curEntry !=null){
                if(!curEntry.isDirectory()) {
                    System.out.println("processing tar entry " + curEntry.getName());
                    String filename = new File(curEntry.getName()).getName();
                    if(originalFile.getName().startsWith(filename)) {
                        System.out.println("extracting " + curEntry.getName());
                        File outputFile = new File(tempDir, filename);
                        final OutputStream outputFileStream = new FileOutputStream(outputFile);
                        IOUtils.copy(tarInput, outputFileStream);
                        outputFileStream.close();
                        //TODO: now we can apply the change file - no we can't we need to order the diffs first... can we do this without writing all of those to disk?
                    }
                }
                curEntry = tarInput.getNextTarEntry();
            }
            break;
        }
    }
}
