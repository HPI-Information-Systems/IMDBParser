package de.hpi.data_change.imdb.data;

import java.time.Year;
import java.util.List;

/**
 * Created by Leon.Bornemann on 7/19/2017.
 */
public class TVEpisode extends Video {

    public TVEpisode(String title, Year year, List<String> extraTokens) {
        super(title, year, extraTokens);
    }

    @Override
    protected VideoType getType() {
        return VideoType.Episode;
    }
}
