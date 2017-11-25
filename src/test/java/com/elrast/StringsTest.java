package com.elrast;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class StringsTest {

    private Strings strings;

    @Before
    public void setUp() {
        strings = new Strings();
    }

    @Test
    public void reverseTest() {

        Assert.assertEquals("cba", strings.reverse("abc"));
    }

    @Test
    public void reverseWordInSentenceTest() {

        String l = "abc cde";
        String result = "cde abc";
        Assert.assertEquals(result, strings.reverseWordInSentence(l));
    }

    @Test
    public void palindromeTest() {

        String word = "abcd";
        String word2 = "abba";
        Assert.assertFalse(strings.isPalindrome(word));
        Assert.assertTrue(strings.isPalindrome(word2));
    }

    @Test
    public void findFirstMatchedCharacter() {

        String first = "la123456789a";
        String second = "sdfghjkla";

        Assert.assertEquals('l', strings.findTheFirstMatchCharacter(first, second));

    }
    @Test
    public void ShouldReversVowel() {

        String input = "abcdio";
        Assert.assertEquals("obcdia", strings.reverseVowelsWithTwoPointer(input));
    }

    @Test
    public void shouldFindMatch() {

        String input = "Brute force to find match";
        String match = "match";

        Assert.assertTrue(strings.findMatch(input, match));
    }

}