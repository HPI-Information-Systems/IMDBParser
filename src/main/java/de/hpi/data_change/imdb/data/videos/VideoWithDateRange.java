package de.hpi.data_change.imdb.data.videos;

import de.hpi.data_change.data.Entity;
import de.hpi.data_change.data.Property;
import de.hpi.data_change.imdb.IOConstants;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public abstract class VideoWithDateRange extends Video{

    private Year endYear;

    public VideoWithDateRange(String title, Year year, List<String> extraTokens) {
        super(title, year, extraTokens);
    }

    public VideoWithDateRange(String title, Year startYear, Year endYear, List<String> extraTokens) {
        super(title,startYear,extraTokens);
        this.endYear = endYear;
    }

    public boolean hasYearRange(){
        return this.endYear !=null;
    }

    @Override
    public Entity toEntity() {
        List<Property> props = new ArrayList<>();
        props.add(new Property("startDate",year == null ? IOConstants.NULL_REPRESENTATION: year.toString()));
        if(hasYearRange()){
            props.add(new Property("endDate",endYear == null ? IOConstants.NULL_REPRESENTATION: year.toString()));
        }
        return new Entity(title, props);
    }
}
