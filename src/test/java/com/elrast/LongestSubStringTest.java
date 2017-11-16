package com.elrast;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestSubStringTest {

    LongestSubString app;

    @Before
    public void setUp() throws Exception {
        app = new LongestSubString();
    }

    @Test
    public void testLengthOfLongestSubstring() throws Exception {

        String input = "abcabcbb";
        assertEquals(3, app.lengthOfLongestSubstring2(input));
        String input2 = "bbbbb";
        assertEquals(1, app.lengthOfLongestSubstring2(input2));
        String input3 = "pwwkew";
        assertEquals(3, app.lengthOfLongestSubstring2(input3));
    }
}