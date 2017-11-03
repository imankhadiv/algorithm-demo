package com.elrast;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class PairSumTest {

    private PairSum pairSum;

    @Before
    public void setUp() throws Exception {

        pairSum = new PairSum();
    }

    @Test
    public void shouldFindPairForSortedArray() throws Exception {

        int[] nums = {1, 2, 4, 4};
        int sum = 8;
        assertTrue(pairSum.findPairForSortedArray(nums, sum));
    }

    @Test
    public void shouldNotFindPairForSortedArray() throws Exception {

        int[] nums = {1, 2, 3, 9};
        int sum = 8;
        assertFalse(pairSum.findPairForSortedArray(nums, sum));
    }

    @Test
    public void shouldReturnFalseWhenInputIsEmpty() throws Exception {

        int[] nums = {};
        int sum = 8;
        assertFalse(pairSum.findPairForSortedArray(nums, sum));
    }

    @Test
    public void shouldNotFindPairInRandomArray() throws Exception {

        int[] nums = {9, 3, 2, 1};
        int sum = 8;
        assertFalse(pairSum.findPairForRandomArray(nums, sum));
    }

    @Test
    public void shouldFindPairForRandomArray() throws Exception {

        int[] nums = {6, 2, 4, 4};
        int sum = 8;
        assertTrue(pairSum.findPairForRandomArray(nums, sum));
    }
}