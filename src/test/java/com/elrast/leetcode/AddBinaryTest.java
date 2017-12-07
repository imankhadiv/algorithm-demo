package com.elrast.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddBinaryTest {

    AddBinary app;
    @BeforeEach
    void setUp() {
        app = new AddBinary();
    }

    @Test
    void shouldNotAddIfInputIsNull() {
        String result = "";
        assertEquals(result, app.addBinary(null,null));
    }

    @Test
    void shouldAddWhenOneInputIsNotEmpty() {
        String result = "1";
        assertEquals(result, app.addBinary("1", null));
    }

    @Test
    void shouldAddTwoOneDigit() {

        String result = "0";
        assertEquals(result, app.addBinary("0","0"));
    }
    @Test
    void shouldAddWhenStringsDoNotHaveEqualLength() {

        String result = "10";
        assertEquals(result, app.addBinary("0","10"));
    }

    @Test
    void shouldAddWhenAddingDigitsGraterThanOne() {

        String result = "100";
        assertEquals(result, app.addBinary("10","10"));
    }


}