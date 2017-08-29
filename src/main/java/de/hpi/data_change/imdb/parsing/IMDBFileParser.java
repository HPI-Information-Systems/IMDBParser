package de.hpi.data_change.imdb.parsing;

import de.hpi.data_change.data.Entity;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.stream.Stream;
import java.util.zip.GZIPInputStream;

public interface IMDBFileParser {

    public void parseGZ(File source) throws IOException;

    public void parseText(File source) throws IOException;

    public Stream<Entity> getEntities();
}
