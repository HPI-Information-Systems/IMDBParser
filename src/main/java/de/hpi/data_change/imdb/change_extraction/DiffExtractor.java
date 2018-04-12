package de.hpi.data_change.imdb.change_extraction;

import de.hpi.data_change.imdb.IOConstants;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;
import org.apache.commons.compress.utils.IOUtils;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class DiffExtractor {

    public void extractDiffFiles(List<File> diffFiles, String originalFilename, File extractionDir) throws IOException {
        for(File tarGzFile : diffFiles) {
            //somehow this seems to get slower with each outer iteration - why?
            System.out.println("processing " + tarGzFile.getName());
            TarArchiveInputStream tarInput = new TarArchiveInputStream(new GzipCompressorInputStream(new FileInputStream(tarGzFile)), IOConstants.ENCODING);
            TarArchiveEntry curEntry = tarInput.getNextTarEntry();
            while(curEntry !=null){
                if(!curEntry.isDirectory()) {
                    String filename = new File(curEntry.getName()).getName();
                    if(originalFilename.startsWith(filename)) {
                        String diffFileName = tarGzFile.getName().split("\\.")[0] + "_" + filename;
                        File outputFile = new File(extractionDir, diffFileName);
                        System.out.println("writing " +diffFileName);
                        final OutputStream outputFileStream = new FileOutputStream(outputFile);
                        IOUtils.copy(tarInput, outputFileStream);
                        outputFileStream.close();
                        break;
                    }
                }
                curEntry = tarInput.getNextTarEntry();
            }
            tarInput.close();
        }
    }

    public static List<File> getDiffFilesInDir(File file) {
        System.out.println(file.getAbsolutePath());
        File[] diffs = file.listFiles(
                (f, fname) -> fname.startsWith("diff") && (fname.endsWith(".tar.gz") || fname.endsWith(".list")));

        return Arrays.asList(diffs);
    }
}
