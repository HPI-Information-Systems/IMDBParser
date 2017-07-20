package de.hpi.data_change.imdb.data;

import java.util.List;

/**
 * Created by Leon.Bornemann on 7/19/2017.
 */
public class Director {

    private String name;
    private List<String> workTitles;

    public Director(String name, List<String> workTitles) {
        this.name = name;
        this.workTitles = workTitles;
    }

    @Override
    public String toString() {
        return "Director{" +
                "name='" + name + '\'' +
                ", workTitles=" + workTitles +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Director director = (Director) o;

        if (name != null ? !name.equals(director.name) : director.name != null) return false;
        return workTitles != null ? workTitles.equals(director.workTitles) : director.workTitles == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (workTitles != null ? workTitles.hashCode() : 0);
        return result;
    }
}
