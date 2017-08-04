package de.hpi.data_change.imdb;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class IOConstants {

    public static final String ENCODING = "UTF8";

    public static final String NULL_REPRESENTATION = "";

    public static final DateTimeFormatter changeDBFormatter = DateTimeFormatter.ofPattern("YYYY-MM-dd[ HH:mm:ss.SSSSSS]");

    public static String toChangeDBStringFormat(LocalDate timestamp) {
        return timestamp.format(changeDBFormatter);
    }
}
