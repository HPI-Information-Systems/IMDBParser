package de.hpi.data_change.data;

import java.io.File;
import java.time.LocalDate;

public class Diff implements Comparable<Diff>{

    private final File diffFile;
    private final LocalDate timestamp;

    public Diff(File diffFile, LocalDate timestamp) {
        this.diffFile = diffFile;
        this.timestamp = timestamp;
    }

    public File getDiffFile() {
        return diffFile;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    @Override
    public int compareTo(Diff diff) {
        return timestamp.compareTo(diff.getTimestamp());
    }
}
