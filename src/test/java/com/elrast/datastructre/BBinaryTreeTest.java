package com.elrast.datastructre;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BBinaryTreeTest {

    BBinaryTree app;

    @BeforeEach
    public void setUp() {
        app = new BBinaryTree<>();
    }

    @Test
    public void longestConsecutiveSequence() {

        app.add(50);
        app.add(19);
        app.add(20);
        app.add(21);
        assertTrue(3 == app.longestConsecutiveSequence(app.getRoot(), 1));

    }

}