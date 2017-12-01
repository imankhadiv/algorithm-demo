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

    @Test
    public void shouldInsertSortedArrayIntoBinaryTree() {

        Integer[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        BBinaryTree.Node result = app.convertSortedArrayToBinaryTreeWithMinHeight(input);

        assertTrue(5 == (Integer) result.getItem());

    }

    @Test
    public void shouldConvertSortedArrayToTree() {

        Integer[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        BBinaryTree.Node result = app.convertSortedArrayToBinaryTree(input);

        assertTrue(4 == (Integer) result.getItem());

    }


}