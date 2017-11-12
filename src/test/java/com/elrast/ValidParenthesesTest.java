package com.elrast;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ValidParenthesesTest {

    private ValidParentheses validP;

    @Before
    public void setUp() {

        validP = new ValidParentheses();
    }

    @Test
    public void shouldReturnTrueForEmptyInput() {

        Assert.assertTrue(validP.isValid(""));
    }
    @Test
    public void shouldRetrunFalseForUnmatchedInput() {

        Assert.assertFalse(validP.isValid("}"));
    }
    @Test
    public void shouldRetrunTrueForMatchedInput() {

        Assert.assertTrue(validP.isValid("()"));
    }

}