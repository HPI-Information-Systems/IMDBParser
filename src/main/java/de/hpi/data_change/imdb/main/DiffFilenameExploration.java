package de.hpi.data_change.imdb.main;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.time.temporal.ChronoUnit;

/**
 * Created by Leon.Bornemann on 7/18/2017.
 */
public class DiffFilenameExploration {

    private static DateTimeFormatter dateParser = DateTimeFormatter.ofPattern("yyyy.MM.dd");

    public static void main(String[] args){
        LocalDate.parse("2000.01.07",dateParser);
        String diffDir = "X:\\HPI_Allgemein\\Arbeitsgruppen\\naumann\\Daten\\IMDB\\Diffs";
        String diffDir2 = "X:\\HPI_Allgemein\\Arbeitsgruppen\\naumann\\Daten\\IMDB\\AlternativeSource";
        File rootDir1 = new File(diffDir);
        File rootDir2 = new File(diffDir);
        List<LocalDate> diffDates = getDates(rootDir1);
        List<LocalDate> diffDates2 = getDates(rootDir2);
        assert(diffDates.size() == diffDates2.size());
        assert(diffDates.equals(diffDates2));
        for (int i = 0;i<diffDates.size()-1;i++){
            LocalDate curDate = diffDates.get(i);
            LocalDate nextDate = diffDates.get(i+1);
            System.out.println(curDate + " \t "+nextDate);
            assert(ChronoUnit.DAYS.between(curDate,nextDate)<=14);
        }
    }

    private static List<LocalDate> getDates(File rootDir) {
        return Arrays.stream(rootDir.listFiles((dir, fname) -> fname.endsWith(".tar.gz") && fname.startsWith("diffs")))
                    .map(file -> file.getName().split("[\\.-]")[1])
                    .map(string -> stringToDate(string))
                    .sorted()
                    .collect(Collectors.toList());
    }

    private static LocalDate stringToDate(String string) {
        assert(string.length() == 6);
        //append so we have the full year:
        String dateString = string.startsWith("9") ? "19" + string : "20" + string;
        dateString = dateString.substring(0,4) + "." + dateString.substring(4,6) + "." + dateString.substring(6,8);
        return LocalDate.parse(dateString, dateParser);
    }
}
