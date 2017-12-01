package com.elrast.datastructre;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MinHeapTest {

    MinHeap<Integer> app;

    @BeforeEach
    void setUp() {
        app = new MinHeap<>();
    }

    @Test
    void addValue() {

        List<Integer> expectedList = new ArrayList<Integer>();
        app.addValue(3);
        app.addValue(9);
        app.addValue(12);
        app.addValue(7);
        app.addValue(1);
        System.out.println(app.heap);
//        assertEquals(java.util.Optional.of(1), (Integer)app.heap.get(0));
    }

    @Test
    void shouldContainsTheValue() {

        app.addValue(0);
        app.addValue(10);
        app.addValue(20);
        assertTrue(app.contains(0));
    }

    @Test
    void shouldFindIndex() {

        app.addValue(0);
        app.addValue(10);
        app.addValue(20);
        assertEquals(2, app.findIndex(20));
    }

    @Test
    void shouldRemoveNode() {

        app.addValue(1);
        app.addValue(3);
        app.addValue(9);
        app.addValue(12);
        app.addValue(13);

        app.remove(1);
        System.out.println(app.heap);

        String s = "hello    world";
        String newS = s.replaceFirst("\\s+", "*");

        System.out.println(s);
        System.out.println(newS);
    }

}