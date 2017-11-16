package com.elrast;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class TwoSumTest {

    private TwoSum twoSum;

    @Before
    public void setUp() throws Exception {
        twoSum = new TwoSum();
    }

    @Test
    public void testTwoSum() throws Exception {

        int[] input = {2, 7, 11, 15};
        int target = 9;
        int[] result = {0, 1};
        assertArrayEquals(result, twoSum.twoSum(input, target));
    }
}