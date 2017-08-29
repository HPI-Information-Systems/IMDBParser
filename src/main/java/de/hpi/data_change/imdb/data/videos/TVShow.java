package de.hpi.data_change.imdb.data.videos;

import java.time.Year;
import java.util.List;

/**
 * Created by Leon.Bornemann on 7/18/2017.
 */
public class TVShow extends VideoWithDateRange {


    public TVShow(String titleString, Year year, List<String> extraTokens) {
        super(titleString,year,extraTokens);
    }

    public TVShow(String titleString, Year startYear, Year endYear, List<String> extraTokens) {
        super(titleString,startYear,endYear,extraTokens);
    }

    @Override
    protected VideoType getType() {
        return VideoType.Series;
    }

}
