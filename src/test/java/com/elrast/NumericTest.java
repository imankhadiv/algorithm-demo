package com.elrast;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class NumericTest {

    private Numeric numeric;

    @Before
    public void setUp() throws Exception {
        numeric = new Numeric();
    }

    @Test
    public void testIsPrime() {

        assertTrue(numeric.isPrime(2));
        assertTrue(numeric.isPrime(3));
        assertTrue(numeric.isPrime(5));
        assertTrue(numeric.isPrime(1));
        assertFalse(numeric.isPrime(4));


        assertTrue(numeric.isPrimeNumber(2));
        assertTrue(numeric.isPrimeNumber(3));
        assertTrue(numeric.isPrimeNumber(5));
        assertTrue(numeric.isPrimeNumber(1));
        assertFalse(numeric.isPrimeNumber(4));


    }

    @Test
    public void testIsPrimeSqrt() {

        assertTrue(numeric.isPrimeNumber(2));
        assertTrue(numeric.isPrimeNumber(3));
        assertTrue(numeric.isPrimeNumber(5));
        assertTrue(numeric.isPrimeNumber(1));
        assertFalse(numeric.isPrimeNumber(400));
    }

    @Test
    public void testIsPrime2() {

        assertTrue(numeric.isPrimeNumber(2));
        assertTrue(numeric.isPrimeNumber(3));
        assertTrue(numeric.isPrimeNumber(5));
        assertTrue(numeric.isPrimeNumber(1));
        assertFalse(numeric.isPrimeNumber(4));
    }

    @Test
    public void testIsPrimeSqrt2() {

        assertTrue(numeric.isPrimeNumber(2));
        assertTrue(numeric.isPrimeNumber(3));
        assertTrue(numeric.isPrimeNumber(5));
        assertTrue(numeric.isPrimeNumber(1));
        assertFalse(numeric.isPrimeNumber(4));
    }

    @Test
    public void convertToBaseTest() {

        String result = "1010";
        assertEquals(result, numeric.convertToBase2(10, 2));
        assertEquals("1011", numeric.convertToBase2(11, 2));

    }

    @Test
    public void findGreatestCommonDenominatorTest() {

        assertEquals(3, numeric.findTheGreatestCommonDenominator(3, 15));
        assertEquals(3, numeric.findTheGreatestCommonDenominator(9, 15));
        assertEquals(5, numeric.findTheGreatestCommonDenominator(10, 5));
        assertEquals(2, numeric.findTheGreatestCommonDenominator(10, 18));
        assertEquals(1, numeric.findTheGreatestCommonDenominator(10, 11));
        assertEquals(10, numeric.findTheGreatestCommonDenominator(10, 100));


    }

    @Test
    public void findGCDTest() {

        assertEquals(3, numeric.gcd(3, 15));
        assertEquals(3, numeric.gcd(9, 15));
        assertEquals(5, numeric.gcd(10, 5));
        assertEquals(2, numeric.gcd(10, 18));
        assertEquals(1, numeric.gcd(10, 11));
        assertEquals(10, numeric.gcd(10, 100));
    }

    @Test
    public void calculateFactorialTest() {

        assertEquals(1, numeric.factorial(1));
        assertEquals(2, numeric.factorial(2));
        assertEquals(6, numeric.factorial(3));
    }

    @Test
    public void shouldSortRotatedInput() {
        int[] input = {8, 9, 10, 11, 3};
        int[] result = {1, 2, 8, 9, 10};
        //Assert.assertEquals(input, numeric.discardRotation(input));
        Assert.assertEquals(3, numeric.findPoint(input));

    }

    @Test
    public void shouldFindMissingNumber() {
        int[] input = IntStream.rangeClosed(2, 100).toArray();
        assertEquals(1, numeric.findPoint(input));
    }
}