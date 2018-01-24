package de.hpi.data_change.imdb.main;

import org.apache.commons.collections.primitives.ArrayIntList;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.QuoteMode;
import org.apache.logging.log4j.core.util.Assert;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.IllegalFormatException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class DataCleaner {

    private static final int PARSING_RECORD = 1;
    private static final int LOOKING_FOR_NEXT = 0;
    private static final int LOOKING_FOR_NEWLINE = 2;
    private static CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.ALL); //withEscape('\\')

    public static void main(String[] args) throws IOException {
        File file = new File("/home/leon/Documents/researchProjects/wikidata/data/totalChanges.csv");
        File fileCleaned = new File("/home/leon/Documents/researchProjects/wikidata/data/cleanedForSpark.csv");
//        List<Path> list = Files.walk(Paths.get(file.getAbsolutePath()))
//                .filter(Files::isRegularFile).collect(Collectors.toList());
        int i=0;
        cleanWikidataForSpark(file.toPath(),fileCleaned);
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

    private static void cleanWikidataForSpark(Path f, File cleanfile) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f.toFile()),"UTF-8"));
        PrintWriter pr = new PrintWriter(cleanfile);
        int droppedCount = 0;
        int r;
        ArrayIntList buffer = new ArrayIntList();
        int state = LOOKING_FOR_NEXT;
        List<String> curRecords = new ArrayList<>();
        int curLine = 1;
        while((r = reader.read())!=-1){
            try {
                if (r == '\n') {
                    curLine++;
                    if(curLine % 1000000==0){
                        System.out.println("processed " + curLine + "lines");
                    }
                }
                if (state == LOOKING_FOR_NEXT) {
                    if (r == '\"') {
                        buffer.add(r);
                        state = PARSING_RECORD;
                    } else if (r =='n'){
                        //null is allowed to be not quoted
                        int char2 = reader.read();
                        int char3 = reader.read();
                        int char4 = reader.read();
                        int char5 = reader.read();
                        if(char2 == 'u' && char3 == 'l' && char4 == 'l' && char5 ==','){
                            curRecords.add("\"\"");
                            if (curRecords.size() < 4) {
                                buffer.clear();
                            } else{
                                throw new AssertionError("Incorrect newline value, not enough records");
                            }
                        } else if (char2 == 'u' && char3 == 'l' && char4 == 'l' && char5 =='\n'){
                            curRecords.add("\"\"");
                            if(curRecords.size() == 4){
                                printToNewFile(pr,curRecords);
                                buffer.clear();
                                curRecords.clear();
                            } else{
                                throw new AssertionError("expected newline after  4 records");
                            }
                        }
                    } else {
                        throw new AssertionError("expected Quote sign");
                    }
                } else if (state == PARSING_RECORD) {
                    if (r == ',' && isDelimiter(buffer)) {
                        curRecords.add(toRecordString(buffer));
                        buffer.clear();
                        if(curRecords.size()<4){
                            state = LOOKING_FOR_NEXT;
                        } else{
                            throw new AssertionError("Incorrect newline value, not enough records");
                        }
                    } else if(r=='\n' && isDelimiter(buffer)){
                        curRecords.add(toRecordString(buffer));
                        buffer.clear();
                        if (curRecords.size() == 4) {
                            printToNewFile(pr,curRecords);
                            buffer.clear();
                            curRecords.clear();
                        } else{
                            throw new AssertionError("expected newline after  4 records");
                        }
                        state = LOOKING_FOR_NEXT;

                    }
                    else {
                        buffer.add(r);
                    }
                } // else if (state == LOOKING_FOR_NEWLINE) {
//                    if (r == '\r') {
//                        int nextChar = reader.read();
//                        if (nextChar == '\n') {
//                            curLine++;
//                            //TODO: print cleaned
//                            printToNewFile(pr,curRecords);
//                            buffer.clear();
//                            curRecords.clear();
//                        } else {
//                            throw new AssertionError("expected \\n after \\r");
//                        }
//                    } else if (r == '\n') {
//                        curLine++;
//                        printToNewFile(pr,curRecords);
//                        buffer.clear();
//                        curRecords.clear();
//                    } else {
//                        throw new AssertionError("expected \\n after reading 4 records");
//                    }
//                }
            } catch(AssertionError e){
                System.out.println("caught error at line "+ curLine);
                System.out.println("Message:" + e.getMessage());
                System.out.println("entering panic mode");
                state = LOOKING_FOR_NEXT;
                buffer.clear();
                curRecords.clear();
                reader.readLine();
            }
        }
    }

    private static void printToNewFile(PrintWriter pr, List<String> curRecords) {
        if(curRecords.size()!=4){
            throw new AssertionError("expected records of size 4");
        }
        String entity = removeBeginAndEndQuotes(curRecords.get(0));
        String property = removeBeginAndEndQuotes(curRecords.get(1));
        String value = removeBeginAndEndQuotes(curRecords.get(2));
        String timestamp = removeBeginAndEndQuotes(curRecords.get(3));
        pr.println(makeNewRecord(entity,property,value,timestamp));
    }

    private static String removeBeginAndEndQuotes(String s) {
        return s.substring(1,s.length()-1);
    }

    private static String toRecordString(ArrayIntList buffer) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<buffer.size();i++){
            sb.append(Character.toChars(buffer.get(i)));
        }
        return sb.toString();
    }

    private static boolean isDelimiter(ArrayIntList buffer) {
        int i=buffer.size()-1;
        int numQuotes = 0;
        while(i>0 && buffer.get(i) == '\"'){
            i--;
            numQuotes++;
        }
        return numQuotes%2 == 1 || numQuotes ==buffer.size();
    }

    private static void clean(Path f, File cleanDir) throws IOException {
        CSVParser res = format.parse(new FileReader(f.toString()));
        PrintWriter pr = new PrintWriter(cleanDir + File.separator + f.getFileName().toString());
        int droppedCount = 0;
        int lines = 1;
        Iterator<CSVRecord> it = res.iterator();
        while(it.hasNext()){
            CSVRecord rec = it.next();
            if(lines % 1000000 == 0){
                System.out.println("processed " + lines + " lines");
                System.out.println("dropped so far: " + droppedCount);
            }
            if(rec.size() != 4){
                droppedCount++;
            } else {
                pr.println(makeNewRecord(rec));
            }
            lines++;
        }
        pr.close();
        System.out.println("dropped " + droppedCount);
        System.out.println("done");
    }

    private static String makeNewRecord(String entity,String property, String value, String timestamp) {
        String del = ",";
        return cleanStringForSpark(entity) + del + cleanStringForSpark(property) + del + cleanStringForSpark(value) + del + cleanStringForSpark(timestamp);
    }

    private static String makeNewRecord(CSVRecord rec) {
        String del = ",";
        return makeNewRecord(rec.get(0),rec.get(1),rec.get(2),rec.get(3));
    }

    private static String cleanStringForSpark(String word) {
//		word = word.replace("&ndash;", "-");
        word = word.replace("\\", "\\\\");
//		word = word.replace(",", "\\,");
        word = word.replace("\"", "\\\"");
        word = word.replace("\r\n","<nl>");
        word = word.replace("\n","<nl>");
        return "\"" +word.substring(0,Math.min(word.length(),500000)) + "\"";
    }
}
