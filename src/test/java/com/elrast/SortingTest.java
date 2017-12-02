package com.elrast;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SortingTest {

    private Sorting sorting;
    private int[] input;

    @Before
    public void setUp() {
        sorting = new Sorting();
        input = new int[]{18, 2, 0, 5, 33};

    }

    @Test
    public void testSort() {

        int[] sorted = new int[]{0, 2, 5, 18, 33};
        int[] result = sorting.sort(input);
        assertTrue(Arrays.equals(sorted, result));

    }

    @Test
    public void testBubbleSort() {

        int[] sorted = new int[]{0, 2, 5, 18, 33};
        int[] result = sorting.bubbleSort(input);
        assertTrue(Arrays.equals(sorted, result));

    }

    @Test
    public void mergeSortTest() {

        int[] sorted = new int[]{0, 2, 5, 18, 33};
        int[] result = sorting.mergeSort(input);
        assertArrayEquals(sorted, result);
    }

    @Test
    public void quickSort() {

        int[] sorted = new int[]{0, 2, 5, 18, 33};
        int[] result = sorting.quickSort(input);
        assertArrayEquals(sorted, result);
    }

    @Test
    public void insertionSort() {

        int[] sorted = new int[]{0, 2, 5, 18, 33};
        int[] result = sorting.insertionSort(input);
        assertArrayEquals(sorted, result);
    }

    @Test
    public void shellSortTest() {

        int[] sorted = new int[]{0, 2, 5, 18, 33};
        int[] result = sorting.shellSort(input);
        assertArrayEquals(sorted, result);
    }

    @Test
    public void shouldMakeAnagramSort() {

        String[] input = {"ab", "iceman", "b", "cinema", "ba"};
        String[] result = {"ab", "ba", "iceman", "cinema", "b"};
        assertArrayEquals(result, sorting.makeAnagramSort(input));
    }

    @Test
    public void shouldFindItemInTheReversedSortedInput() {

        int item = 2;
        int[] input = {8, 9, 1, 2, 3};
        assertEquals(3, sorting.findItemInReturnedSortedInput(input, item));
        int[] input2 = {10, 15, 20, 0, 5};
        item = 5;
        assertEquals(4, sorting.findItemInReturnedSortedInput(input2, item));
        int[] input3 = {50, 5, 20, 30, 40};
        assertEquals(1, sorting.findItemInReturnedSortedInput(input3, item));

    }

    @Test
    public void shouldFindItemWhenThereIsDuplicate() {

        int item = 3;
        int[] input = {2, 2, 2, 3, 4, 2};
        assertEquals(3, sorting.findItemInReturnedSortedInput(input, item));

    }

}