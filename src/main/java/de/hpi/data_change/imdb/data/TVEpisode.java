package de.hpi.data_change.imdb.data;

import java.time.Year;
import java.util.List;

/**
 * Created by Leon.Bornemann on 7/19/2017.
 */
public class TVEpisode extends Video {

    private Year endYear;

    public TVEpisode(String title, Year year, List<String> extraTokens) {
        super(title, year, extraTokens);
    }

    public TVEpisode(String title, Year startYear, Year endYear, List<String> extraTokens) {
        super(title,startYear,extraTokens);
        this.endYear = endYear;
    }

    public String getEpisodeName(){
        int startIndex = title.indexOf('{')+1;
        int endIndex = title.lastIndexOf('}');
        String episodeTitle = title.substring(startIndex, endIndex);
        return episodeTitle;
    }

    @Override
    protected VideoType getType() {
        return VideoType.Episode;
    }
}
