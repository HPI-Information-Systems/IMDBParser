package de.hpi.data_change.imdb.data;

import de.hpi.data_change.data.Entity;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DirectorTest {

    @Test
    void toEntity() {
        String christopher_nolan = "Christopher Nolan";
        String michael_bay = "Michael Bay";
        Director director1 = new Director(christopher_nolan, Arrays.asList("Memento","The Prestige","Awesome Batman Movie, :)"));
        Director director2 = new Director(michael_bay,Arrays.asList("Explosions: The Movie"));
        Entity entity = director1.toEntity();
        assertEquals(christopher_nolan,entity.getName());
        assertEquals(1,entity.getProperties().size());
        assertEquals("[\"Memento\",\"The Prestige\",\"Awesome Batman Movie, :)\"]",entity.getProperties().get(0).getValue());
        entity = director2.toEntity();
        assertEquals(michael_bay,entity.getName());
        assertEquals(1,entity.getProperties().size());
        assertEquals("[\"Explosions: The Movie\"]",entity.getProperties().get(0).getValue());
    }

}