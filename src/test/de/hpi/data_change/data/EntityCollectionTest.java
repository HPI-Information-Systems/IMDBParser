package de.hpi.data_change.data;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class EntityCollectionTest {

    private static LocalDate timestamp1 = LocalDate.of(2017, 7, 27);
    private static LocalDate timestamp2 = LocalDate.of(2017, 7, 28);

    @Test
    void appendChanges() throws FileNotFoundException {
        File testOut = new File("resources/testOutput/EntityCollectionChangeTest.txt");
        testOut.delete();
        //old collection 1:
        Entity e1 = new Entity("e1",Arrays.asList(new Property("a","1"),new Property("b","1")));
        Entity e2 = new Entity("e2",Arrays.asList(new Property("a","1"),new Property("b","1"),new Property("c","1")));
        List<Entity> entities = Arrays.asList(e1,e2);
        EntityCollection colOld = new EntityCollection(entities, timestamp1);
        //new collection:
        Entity e3 = new Entity("e3",Arrays.asList(new Property("e","5")));
        Entity e2New = new Entity("e2",Arrays.asList(new Property("a","1"),new Property("b","2"),new Property("d","1")));
        entities = Arrays.asList(e3,e2New);
        EntityCollection colNew = new EntityCollection(entities, timestamp2);
        colNew.appendChanges(colOld,testOut);
        BufferedReader reader = new BufferedReader(new FileReader(testOut));
        List<String> lines = reader.lines().collect(Collectors.toList());
        assertTrue(lines.contains("\"e3\",\"e\",\"5\",2017-07-28"));
        assertTrue(lines.contains("\"e1\",\"a\",\"\",2017-07-28"));
        assertTrue(lines.contains("\"e1\",\"b\",\"\",2017-07-28"));
        assertTrue(lines.contains("\"e2\",\"b\",\"2\",2017-07-28"));
        assertTrue(lines.contains("\"e2\",\"d\",\"1\",2017-07-28"));
        assertTrue(lines.contains("\"e2\",\"c\",\"\",2017-07-28"));
        assertEquals(6,lines.size());
        //TODO: finish asserting
    }

    @Test
    void toIntitialChangeFile() throws IOException {
        File testOut = new File("resources/testOutput/EntityCollectionTest.txt");
        Entity e1 = new Entity("e1",Arrays.asList(new Property("p1","v1")));
        Entity e2 = new Entity("e2",Arrays.asList(new Property("p1","v2"),new Property("p2","v3")));
        List<Entity> entities = Arrays.asList(e1,e2);
        EntityCollection col = new EntityCollection(entities, timestamp1);
        col.toIntitialChangeFile(testOut);
        BufferedReader reader = new BufferedReader(new FileReader(testOut));
        assertEquals("\"e1\",\"p1\",\"v1\",2017-07-27" ,reader.readLine());
        assertEquals("\"e2\",\"p1\",\"v2\",2017-07-27" ,reader.readLine());
        assertEquals("\"e2\",\"p2\",\"v3\",2017-07-27" ,reader.readLine());
        reader.close();
    }

}