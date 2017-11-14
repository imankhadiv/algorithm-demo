package com.elrast;

import com.sun.source.tree.AssertTree;
import org.junit.Before;
import org.junit.Test;
import sun.jvm.hotspot.utilities.Assert;

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
    public void testIsPrimeSqrt(){

        assertTrue(numeric.isPrimeNumber(2));
        assertTrue(numeric.isPrimeNumber(3));
        assertTrue(numeric.isPrimeNumber(5));
        assertTrue(numeric.isPrimeNumber(1));
        assertFalse(numeric.isPrimeNumber(4));
    }
}