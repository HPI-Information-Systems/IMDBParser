package de.hpi.data_change.imdb;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class IOConstants {

    public static final String ENCODING = "UTF8";

    public static final String NULL_REPRESENTATION = "";

    public static final DateTimeFormatter changeDBFormatter = DateTimeFormatter.ofPattern("YYYY-MM-dd[ HH:mm:ss.SSSSSS]");

    public static String toChangeDBStringFormat(LocalDate timestamp) {
        return timestamp.format(changeDBFormatter);
    }

    public static String getEncodingFromFileHeader(File file) throws IOException {
        InputStream is = new FileInputStream(file);
        byte[] bytes = new byte[3];
        is.read(bytes);
        is.close();
        //check for UTF-16 normal:
        if(bytes[0] == 0xFF && bytes[1] == 0xFE){
            return "UTF-16LE";
            //UTF-16, little-endian
        } else if(bytes[0] == 0xFE && bytes[1] == 0xFF){
            //UTF-16, big-endian
            return "UTF-16BE";
        } else if(bytes[0] == 0xFF && bytes[1] == 0xFD){
            //UTF-16, big-endian
            return "UTF-16LE";
        }else if (bytes[0] == 0xEF && bytes[1] == 0xBB && bytes[2] == 0xBF){
            //UTF8
            return "UTF-8";
        } else{
            System.err.println("Warn: File format not recognized from header - we assume UTF-8. Header Bytes were: " + bytes[0] + "," + bytes[1] + "," + bytes[2]);
            return "UTF-8";
        }
    }
}
