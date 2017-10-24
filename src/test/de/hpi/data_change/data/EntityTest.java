package de.hpi.data_change.data;


import org.junit.jupiter.api.Test;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;


public class EntityTest {

    @Test
    void mergeEntitiesTest(){
        ArrayList<Property> props1 = new ArrayList<Property>();
        props1.add(new Property("A","val_A"));
        props1.add(new Property("B","val_B"));
        props1.add(new Property("C","val_1C"));
        Entity entity1 = new Entity("TestEntity",props1);
        //ENtity 2:
        ArrayList<Property> props2 = new ArrayList<Property>();
        props2.add(new Property("A","val_A"));
        props2.add(new Property("C","val_2C"));
        props1.add(new Property("D","val_D"));
        Entity entity2 = new Entity("TestEntity",props1);
        Entity mergeResult = entity1.merge(entity2);
        assertEquals(4,mergeResult.getProperties().size());
        assertEquals("val_A",mergeResult.getValue("A"));
        assertEquals("val_B",mergeResult.getValue("B"));
        assertEquals("val_1Cval_2C",mergeResult.getValue("C"));
        assertEquals("val_D",mergeResult.getValue("D"));


    }
}
