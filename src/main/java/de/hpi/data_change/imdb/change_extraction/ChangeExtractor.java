package de.hpi.data_change.imdb.change_extraction;

import de.hpi.data_change.data.EntityCollection;
import de.hpi.data_change.data.Diff;
import de.hpi.data_change.imdb.change_extraction.DiffApplyer;
import de.hpi.data_change.imdb.change_extraction.DiffExtractor;
import de.hpi.data_change.imdb.parsing.directors.DirectorsReader;

import java.io.*;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Leon.Bornemann on 7/21/2017.
 */
public class ChangeExtractor {

    private final File targetDir;
    private final List<File> diffFiles;
    private final File originalFile;
    private final File diffDir;
    private boolean diffDirIsTemporary = false;
    private String entityType;
    private DiffApplyer diffApplyer = new DiffApplyer();


    public ChangeExtractor(File originalFile, List<File> diffFiles, File targetDir,File diffDir) {
        this.originalFile = originalFile;
        this.diffFiles = diffFiles;
        this.targetDir = targetDir;
        this.diffDir = diffDir;
        entityType = originalFile.getName().split("\\.")[0];
    }

    public ChangeExtractor(File originalFile, List<File> diffFiles, File targetDir) throws IOException {
        this.originalFile = originalFile;
        this.diffFiles = diffFiles;
        this.targetDir = targetDir;
        this.diffDir = Files.createTempDirectory("temporary").toFile();
        diffDir.deleteOnExit();
        this.diffDirIsTemporary = true;
        entityType = originalFile.getName().split("\\.")[0];
    }

    public void extractChanges() throws IOException, InterruptedException {
        String entityType = originalFile.getName().split("\\.")[0];
        List<Diff> diffs;
        if(diffFilesAreCompressed()) {
            System.out.println("launching decompression and extraction of diff files");
            DiffExtractor extractor = new DiffExtractor();
            extractor.extractDiffFiles(diffFiles, originalFile.getName(), diffDir);
            if (diffDirIsTemporary) {
                Arrays.stream(diffDir.listFiles()).forEach(f -> f.deleteOnExit());
            }
            diffs = Arrays.stream(diffDir.listFiles())
                    .map(f -> new Diff(f, toDate(f.getName())))
                    .collect(Collectors.toList());
        } else{
            System.out.println("directly accessing diff files");
            diffs = diffFiles.stream()
                    .map(f -> new Diff(f, toDate(f.getName())))
                    .collect(Collectors.toList());
        }
        File source = getOldestVersion(diffs);
        //Change database writing:
        extractForwardChanges(diffs, source);
    }

    private boolean diffFilesAreCompressed() {
        return diffFiles.stream().map(f -> f.getName()).allMatch(fname -> fname.endsWith(".gz"));
    }

    private File getOldestVersion(List<Diff> diffs) throws IOException, InterruptedException {
        List<Diff> diffsOrdered = diffs.stream()
                .sorted((d1, d2) -> d2.getTimestamp().compareTo(d1.getTimestamp()))
                .collect(Collectors.toList());
        File source = new File(originalFile.getAbsolutePath());
        System.out.println(source.getAbsolutePath());
        System.out.println(source.getParentFile().getAbsolutePath());
        File target = new File(source.getParentFile(),"intermediate_" + originalFile.getName());
        for (Diff diffFile : diffsOrdered) {
            diffApplyer.applyDiffBackwards(source,diffFile.getDiffFile(),target);
            source = target;
        }
        return source;
    }

    private void extractForwardChanges(List<Diff> diffsOrdered, File source) throws IOException, InterruptedException {
        DirectorsReader directorsReader = new DirectorsReader();
        directorsReader.parseGZ(source);
        Collections.sort(diffsOrdered);
        EntityCollection originalCollection = new EntityCollection(directorsReader.getDirectors().stream().map(d -> d.toEntity()).collect(Collectors.toList()),diffsOrdered.get(0).getTimestamp());
        File changeFile = new File(targetDir,"changes.csv");
        originalCollection.toIntitialChangeFile(changeFile);
        EntityCollection current = originalCollection;
        File currentFile = source;
        for(Diff diff : diffsOrdered){
            System.out.println("Applying forward diff " + diff.getDiffFile().getName() + "  " + diff.getTimestamp());
            diffApplyer.applyDiffForwards(currentFile,diff.getDiffFile(),currentFile);
            directorsReader.parseText(currentFile);
            EntityCollection updatedCollection = new EntityCollection(directorsReader.getDirectors().stream().map(d -> d.toEntity()).collect(Collectors.toList()),diff.getTimestamp());
            updatedCollection.appendChanges(current,changeFile);
            //update:
            current = updatedCollection;
        }
    }

    private LocalDate toDate(String name) {
        String shortDateStr = name.split("_")[0].split("-")[1];
        assert(shortDateStr.length()==6);
        int year;
        if(shortDateStr.startsWith("9")){
            year = Integer.parseInt("19" + shortDateStr.substring(0,2));
        } else{
            year = Integer.parseInt("20" + shortDateStr.substring(0,2));
        }
        int month = Integer.parseInt(shortDateStr.substring(2,4));
        int day = Integer.parseInt(shortDateStr.substring(4,6));
        return LocalDate.of(year,month,day);
    }
}
