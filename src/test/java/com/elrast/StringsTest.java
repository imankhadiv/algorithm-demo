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

    @Test
    public void shouldReplaceSpaceWithTwentyPercent() {

        String input = "a bc ";
        char[] result = {'a', '%', '2', '0', 'b', 'c', '%', '2', '0'};
        System.out.println(strings.replaceSpaceWithPercentTwenty(input));
        Assert.assertTrue(result == strings.replaceSpaceWithPercentTwenty(input));
    }

    @Test
    public void shouldCompressString() {

        String input = "aabcccccaaa";
        String result = "a2b1c5a3";
        Assert.assertEquals(result, strings.compressString(input));
    }
    @Test
    public void shouldNotCompressTheString() {

        String input = "abcde";
        String result = "abcde";
        Assert.assertEquals(result, strings.compressString(input));
    }

}