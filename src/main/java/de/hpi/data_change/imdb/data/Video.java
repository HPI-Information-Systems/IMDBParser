package de.hpi.data_change.imdb.data;

import java.time.Year;
import java.util.List;

/**
 * Created by Leon.Bornemann on 7/18/2017.
 */
public abstract class Video {

    protected String title;
    protected Year year;
    protected List<String> extraTokens;


    public Video(String title, Year year,List<String> extraTokens) {
        this.title = title;
        this.year = year;
        this.extraTokens = extraTokens;
    }

    public static Video createFromTokens(String titleString, String yearString, List<String> extraTokens) {
        if(titleString.startsWith("\"")){
            //assert(titleString.charAt(titleString.lastIndexOf('\"')+1) == ' ');
            if(yearString.indexOf('-')!=-1){
                String[] yearTokens = yearString.split("-");
                Year startYear = parseYear(yearTokens[0]);
                Year endYear = parseYear(yearTokens[1]);
                return new TVShow(titleString,startYear,endYear,extraTokens);
            } else {
                return new TVShow(titleString, parseYear(yearString), extraTokens);
            }
        } else{
            return new Movie(titleString,parseYear(yearString),extraTokens);
        }
    }

    private static Year parseYear(String yearString) {
        if(yearString.equals("????")){
            return null;
        } else {
            return Year.parse(yearString);
        }
    }

    protected abstract VideoType getType();

    @Override
    public String toString() {
        return getType() + " {"+
                "title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", extraTokens=" + extraTokens +
                '}';
    }
}
