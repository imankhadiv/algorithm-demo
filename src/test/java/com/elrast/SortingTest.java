package com.elrast;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

public class SortingTest {

    private Sorting sorting;
    private int[] input;

    @Before
    public void setUp() {
        sorting = new Sorting();
        input = new int[]{18, 2, 0, 5};

    }

    @Test
    public void testSort() {

        int[] sorted = new int[]{0, 2, 5, 18};
        int[] result = sorting.sort(input);
        assertTrue(Arrays.equals(sorted, result));

    }

    @Test
    public void testBubbleSort() {

        int[] sorted = new int[]{0, 2, 5, 18};
        int[] result = sorting.bubbleSort(input);
        assertTrue(Arrays.equals(sorted, result));

    }

    @Test
    public void mergeSortTest() {

        int[] sorted = new int[]{0, 2, 5, 18};
        int[] result = sorting.mergeSort(input);
        assertArrayEquals(sorted, result);
    }

}