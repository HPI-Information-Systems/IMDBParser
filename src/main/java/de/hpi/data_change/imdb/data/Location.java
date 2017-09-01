package de.hpi.data_change.imdb.data;

import de.hpi.data_change.data.Entity;
import de.hpi.data_change.data.Property;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Location extends MultiPropertyEntity{

    public Location(String title, List<List<String>> allvals) {
        super(title, transformElementsToStringPair(allvals));
    }

    private static List<String> transformElementsToStringPair(List<List<String>> allvals) {
        for (List<String> val : allvals) {
            assert val.size()==2;
        }
        return allvals.stream().map( l -> "{location:"+ l.get(0) + ",description:" + l.get(1) + "}").collect(Collectors.toList());
    }

    @Override
    protected String getPersonType() {
        return "Location";
    }
}
