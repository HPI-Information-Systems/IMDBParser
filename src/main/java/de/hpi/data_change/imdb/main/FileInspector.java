package de.hpi.data_change.imdb.main;

import java.io.*;
import java.util.stream.Collectors;

public class FileInspector {


    private final BufferedReader br;

    public FileInspector(File src) throws FileNotFoundException {
        this.br = new BufferedReader(new FileReader(src));
    }

    public void printDetailedLine() throws IOException {
        String line = br.readLine();
        System.out.println(line);
        line.chars().forEachOrdered(c -> System.out.print(c + " "));
        System.out.println();
    }

    public String nextLine() throws IOException {
        return br.readLine();
    }
}
