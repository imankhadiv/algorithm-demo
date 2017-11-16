package com.elrast;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ZigZagTest {

    private ZigZag zigzag;

    @BeforeEach
    void setUp() {
        zigzag = new ZigZag();
    }

    @Test
    void makeZigZagTest1() {

        int[] input = {20, 30, 50};
        int[] result = {20, 50, 30};
        Assert.assertArrayEquals(result, zigzag.makeZigZagArray(input));
    }

    @Test
    public void makeZigZagTest2() {

        int[] input = {4, 3, 7, 8, 6, 2, 1};
        int[] result = {3, 7, 4, 8, 2, 6, 1};
        Assert.assertArrayEquals(result, zigzag.makeZigZagArray(input));
    }

    @Test
    public void makeZigZagTest3() {

        int[] input = {20, 30, 50, 20};
        int[] result = {20, 50, 20, 30};
        Assert.assertArrayEquals(result, zigzag.makeZigZagArray(input));
    }

}