package de.hpi.data_change.data;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EntityCollectionTest {

    @Test
    void toIntitialChangeFile() throws IOException {
        File testOut = new File("resources/testOutput/EntityCollectionTest.txt");
        Entity e1 = new Entity("e1",Arrays.asList(new Property("p1","v1")));
        Entity e2 = new Entity("e2",Arrays.asList(new Property("p1","v2"),new Property("p2","v3")));
        List<Entity> entities = Arrays.asList(e1,e2);
        EntityCollection col = new EntityCollection(entities, LocalDate.now());
        col.toIntitialChangeFile(testOut);
        BufferedReader reader = new BufferedReader(new FileReader(testOut));
        assertEquals("\"e1\",\"p1\",\"v1\",2017-07-27" ,reader.readLine());
        assertEquals("\"e2\",\"p1\",\"v2\",2017-07-27" ,reader.readLine());
        assertEquals("\"e2\",\"p2\",\"v3\",2017-07-27" ,reader.readLine());
        reader.close();
    }

}