package com.elrast;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConvertingStringsTest {
    ConvertingStrings app;
    @Before
    public void setUp() throws Exception {
        app = new ConvertingStrings();
    }
    @Test
    public void shouldNotConvertEmptyStrings() {
        String s1 = "";
        String s2 = "";
        assertEquals(0, app.convertS1ToS2WithMinChange(s1, s2));
    }
    @Test
    public void shouldReturnLengthOfNoneEmptyString() {
        String s1 = "ab";
        String s2 = "";
        assertEquals(2, app.convertS1ToS2WithMinChange(s1, s2));

    }
    @Test
    public void testConvertS1ToS2WithMinChange() throws Exception {
        String s1 = "This";
        String s2 = "It is";
        assertEquals(3, app.convertS1ToS2WithMinChange(s1, s2));

    }
}