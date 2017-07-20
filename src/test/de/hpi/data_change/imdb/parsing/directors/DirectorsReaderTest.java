package de.hpi.data_change.imdb.parsing.directors;

import de.hpi.data_change.imdb.data.Director;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Leon.Bornemann on 7/20/2017.
 */
class DirectorsReaderTest {

    @Test
    public void testDirectorsReader() throws IOException {
        DirectorsReader reader = new DirectorsReader();
        reader.parseText(new File("resources/testData/directorTest.txt"));
        List<Director> result = reader.getDirectors();
        assertEquals(new Director("&OumlZkahraman, Ender", Arrays.asList("Ugly Duckling (2017)")),result.get(0));
        assertEquals(new Director("'s-Gravesande, Pjotr",
                Arrays.asList("Editors: The Back Room (Festival Edition) (2005) (V)",
                        "Go Back to the Zoo: Live at Paradiso 2011 (2011) (V)",
                        "Lucie Silvas: Live in Amsterdam (2007) (V)",
                        "Milow: Maybe Next Year - Live in Amsterdam (2009) (V)  (uncredited)",
                        "Thomas Dybdahl: Live at the Paradiso, Amsterdam (2009) (V)",
                        "Wir Sind Helden - Soundso (2007) (V)"))
                ,result.get(result.size()-1));
    }
}