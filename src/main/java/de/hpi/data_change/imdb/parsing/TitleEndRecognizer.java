package de.hpi.data_change.imdb.parsing;

import de.hpi.data_change.data.Pair;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TitleEndRecognizer {

    //private static final String regexLastTitleElement = "\\(((([0-9]{4}|\\?{4})(/([IXVL])+)?)|TV|V|VG)\\)|\\{\\{SUSPENDED\\}\\}|\\{(.*?)\\}|\\([0-9]{4}\\)";

    private static final Pattern suspendedPattern = Pattern.compile("\\{\\{SUSPENDED\\}\\}");
    private static final Pattern yearPattern = Pattern.compile("\\(([0-9]{4}|\\?{4})(/([IXVL])+)?\\)");
    private static final Pattern typePattern = Pattern.compile("\\((TV|V|VG)\\)");
    private static final Pattern episodeNamePattern = Pattern.compile("\\{(.*?)\\}");

    public static Pair<String,String> splitAfterTitle(String line){
        Matcher yearMatcher = yearPattern.matcher(line);
        boolean foundYear = yearMatcher.find();
        assert(foundYear);
        int preliminaryStart = yearMatcher.end();
        String fromYearEnd = line.substring(preliminaryStart);
        //other matchers
        Matcher typeMatcher = typePattern.matcher(fromYearEnd);
        Matcher episodeNameMatcher = episodeNamePattern.matcher(fromYearEnd);
        Matcher supendedMatcher = suspendedPattern.matcher(fromYearEnd);
        int secondHalfStart = preliminaryStart;
        if(supendedMatcher.find()){
            secondHalfStart = supendedMatcher.end() + preliminaryStart;
        } else if(episodeNameMatcher.find()){
            secondHalfStart = episodeNameMatcher.end() + preliminaryStart;
        } else if (typeMatcher.find()) {
            secondHalfStart = typeMatcher.end() + preliminaryStart;
        }
        return new Pair<>(line.substring(0,secondHalfStart),line.substring(secondHalfStart));
    }

    public static int lastIndexOfRegex(Matcher matcher) {
        // Default to the NOT_FOUND constant
        int lastIndex = -1;
        // Search for the given pattern
        while (matcher.find())
        {
            lastIndex = matcher.end();
        }
        assert(lastIndex!=-1);
        return lastIndex;
    }
}
