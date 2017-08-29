package de.hpi.data_change.imdb.main;

import de.hpi.data_change.imdb.change_extraction.DiffApplyer;
import de.hpi.data_change.imdb.data.TableType;
import de.hpi.data_change.imdb.parsing.IMDBFileANTLRGeneratedParser;
import de.hpi.data_change.imdb.parsing.IMDBFileParser;

import java.io.File;
import java.io.IOException;

public class SingleFileParsing {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Parsing single File");
        IMDBFileParser parser = IMDBFileANTLRGeneratedParser.createParser(TableType.Actor);
        File src = new File("C:\\Users\\Leon.Bornemann\\Documents\\Database Changes\\Data\\IMDB\\Database\\actors.list\\actors.list");
        parser.parseText(src);
        parser.getEntities().limit(100).forEach(e -> System.out.println(e));
    }
}
