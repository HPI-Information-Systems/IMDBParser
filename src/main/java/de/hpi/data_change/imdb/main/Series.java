package de.hpi.data_change.imdb.main;

import java.time.Year;
import java.util.List;

/**
 * Created by Leon.Bornemann on 7/18/2017.
 */
public class Series extends Video {

    private Year endYear;

    public Series(String titleString, Year year, List<String> extraTokens) {
        super(titleString,year,extraTokens);
        this.endYear = null;
    }

    public Series(String titleString, Year startYear, Year endYear, List<String> extraTokens) {
        super(titleString,startYear,extraTokens);
        this.endYear = endYear;
    }

    public boolean hasYearRange(){
        return this.endYear !=null;
    }

    @Override
    protected VideoType getType() {
        return VideoType.Series;
    }


}
