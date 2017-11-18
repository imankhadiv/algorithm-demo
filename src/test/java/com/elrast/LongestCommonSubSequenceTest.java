package com.elrast;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestCommonSubSequenceTest {

    LongestCommonSubSequence app;

    @Before
    public void setUp() throws Exception {

        app = new LongestCommonSubSequence();
    }

    @Test
    public void shouldReturnZeroWhenThereIsNotCommonSub() throws Exception {

        String s1 = "a";
        String s2 = "B";
        assertEquals(0, app.find(s1, s2));
    }

    @Test
    public void shouldReturnOneWhenThereIsOneCommonSub() throws Exception {

        String s1 = "a";
        String s2 = "ba";
        assertEquals(1, app.find(s1, s2));
    }

    @Test
    public void shouldReturnCommonSub() throws Exception {

        String s1 = "aa";
        String s2 = "baa";
        assertEquals(2, app.find(s1, s2));
    }

    @Test
    public void shouldReturnLongestCommonSub() throws Exception {

        String s1 = "aabaa";
        String s2 = "baa";
        assertEquals(3, app.find(s1, s2));
    }
}