package de.hpi.data_change.imdb.main;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.QuoteMode;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class DataCleaner {

    private static CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.ALL); //withEscape('\\')

    public static void main(String[] args) throws IOException {
        File file = new File("/home/leon/Documents/researchProjects/imdb/changeDB");
        File fileCleaned = new File("/home/leon/Documents/researchProjects/imdb/changeDB/cleaned/");
        List<Path> list = Files.walk(Paths.get(file.getAbsolutePath()))
                .filter(Files::isRegularFile).collect(Collectors.toList());
        int i=0;
        File in = new File("/home/leon/Documents/researchProjects/wikidata/data/settlementsNew.csv");
        File out = new File("/home/leon/Documents/researchProjects/wikidata/data/");
        clean(in.toPath(),out);
        //cleanAll(fileCleaned, list, i);
    }

    private static void cleanAll(File fileCleaned, List<Path> list, int i) throws IOException {
        for(Path p : list){
            System.out.println("Cleaning " + p);
            System.out.println(i + "out of " + list.size() + " (" +(100.0 * (double)i)/list.size() + "%)" );
            clean(p,fileCleaned);
            i++;
        }
    }

    private static void clean(Path f, File cleanDir) throws IOException {
        CSVParser res = format.parse(new FileReader(f.toString()));
        PrintWriter pr = new PrintWriter(cleanDir + File.separator + f.getFileName().toString());
        for(CSVRecord rec : res.getRecords()){
            pr.println(makeNewRecord(rec));
        }
        pr.close();
        System.out.println("done");
    }

    private static String makeNewRecord(CSVRecord rec) {
        String del = ",";
        return cleanString(rec.get(0)) + del + cleanString(rec.get(1)) + del + cleanString(rec.get(2)) + del + cleanString(rec.get(3));
    }

    private static String cleanString(String s) {
        return "\"" + cleanStringFromTobias(s) + "\"";
    }

    private static String cleanStringFromTobias(String word) {
//		word = word.replace("&ndash;", "-");
        word = word.replace("\\", "\\\\");
//		word = word.replace(",", "\\,");
        word = word.replace("\"", "\\\""); // this is significant, as I am
        // actually changing the content
        return word;
    }
}
