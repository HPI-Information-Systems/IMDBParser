package de.hpi.data_change.imdb.change_extraction;

import de.hpi.data_change.data.EntityCollection;
import de.hpi.data_change.data.Diff;
import de.hpi.data_change.imdb.IOConstants;
import de.hpi.data_change.imdb.data.TableType;
import de.hpi.data_change.imdb.parsing.IMDBFileParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Leon.Bornemann on 7/21/2017.
 */
public class ChangeExtractor {

    final static Logger logger = LogManager.getLogger(ChangeExtractor.class);

    private final File targetDir;
    private final List<File> diffFiles;
    private final File originalFile;
    private final File diffDir;
    private boolean diffDirIsTemporary = false;
    private TableType tableType;
    private DiffApplyer diffApplyer = new DiffApplyer();

    public ChangeExtractor(File originalFile, List<File> diffFiles, File targetDir,File diffDir,TableType tableType) {
        this.originalFile = originalFile;
        this.diffFiles = diffFiles;
        this.targetDir = targetDir;
        this.diffDir = diffDir;
        this.tableType = tableType;//originalFile.getName().split("\\.")[0];
    }

    public void extractChanges() throws IOException, InterruptedException {
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
        File source = extractChanges(diffs);
    }

    private boolean diffFilesAreCompressed() {
        return diffFiles.stream().map(f -> f.getName()).allMatch(fname -> fname.endsWith(".gz"));
    }

    private File extractChanges(List<Diff> diffs) throws IOException, InterruptedException {
        logger.info("Starting to extract changes");
        List<Diff> diffsOrdered = diffs.stream()
                .sorted((d1, d2) -> d2.getTimestamp().compareTo(d1.getTimestamp()))
                .collect(Collectors.toList());
        File source = new File(originalFile.getAbsolutePath());
        File tempFile1 = new File(source.getParentFile(),"intermediate_" + originalFile.getName());
        File tempFile2 = new File(source.getParentFile(),"intermediate_2_" + originalFile.getName());
        File target = tempFile1;
        LocalDate prevTimestamp = diffsOrdered.get(0).getTimestamp().plus(7, ChronoUnit.DAYS); //TODO: is this correct - we assume that the date of the diff identifies the previous version - it might be the other way around, however it does not really matter for the data contained
        for (int i=0;i<diffsOrdered.size();i++) {
            Diff diffFile = diffsOrdered.get(i);
            if(target.getCanonicalPath().equals(source.getCanonicalPath())){
                //switch target file:
                target = target.getCanonicalPath().equals(tempFile1.getCanonicalPath()) ? tempFile2 : tempFile1;
            }
            assert(!target.equals(source));
            logger.info("Starting to apply Diff File {} backwards from {} to {}", diffFile.getDiffFile().getAbsolutePath(),source.getAbsolutePath(),target.getAbsolutePath());
            boolean withoutRejects = diffApplyer.applyDiffBackwards(source,diffFile.getDiffFile(),target);
            if(!withoutRejects){
                logger.error("Rejects appeared when applying patch");
                throw new AssertionError("Rejects appeared when applying patch");
            }
            logger.info("Finished applying Diff without problems");
            //extract changes
            logger.info("Starting to extract changes");
            //TODO: timestamp problems...
            EntityCollection laterVersion = parseFile(source, prevTimestamp);
            EntityCollection earlierVersion = parseFile(target, diffFile.getTimestamp());
            File changeFile = new File(targetDir, IOConstants.toChangeDBStringFormat(diffFile.getTimestamp()) + "_" + tableType  +"_changes.csv");
            laterVersion.appendChanges(earlierVersion,changeFile);
            logger.info("Finished extracting changes");
            source = target;
            prevTimestamp = diffFile.getTimestamp();
            if(i==diffsOrdered.size()-1){
                File initialFile = new File(targetDir, "initial_inserts.csv");
                earlierVersion.toIntitialChangeFile(initialFile);
            }
        }
        return source;
    }

    private EntityCollection parseFile(File source, LocalDate timestamp) throws IOException {
        IMDBFileParser parser = IMDBFileParser.createParser(tableType);
        if(source.getName().endsWith(".gz")) {
            parser.parseGZ(source);
        } else{
            assert(source.getName().endsWith(".list"));
            parser.parseText(source);
        }
        return new EntityCollection(parser.getEntities(), timestamp);
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
