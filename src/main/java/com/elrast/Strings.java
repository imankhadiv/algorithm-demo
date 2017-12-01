package com.elrast;

import java.util.*;

public class Strings {

    public String reverse(String word) {
        if (word.length() == 1) {
            return word;
        }
        return reverse(word.substring(1, word.length())) + word.substring(0, 1);
    }

    public String reverseWordInSentence(String line) {

        StringBuffer stringBuffer = new StringBuffer();
        int last = line.length() - 1;
        int start = last;
        while (last > 0) {

            while (start > 0 && line.substring(start, start + 1).equals(" ")) {
                start--;
            }
            last = start;
            while (start >= 0 && !line.substring(start, start + 1).equals(" ")) {
                start--;
            }
            stringBuffer.append(line.substring(start + 1, last + 1));
            last = start;
            if (start > 0) {
                stringBuffer.append(" ");
            }
        }
        return stringBuffer.toString();
    }

    public boolean isPalindrome(String word) {
        int length = word.length();
        for (int i = 0; i < length; i++) {
            if (!word.substring(i, i + 1).equals(word.substring(length - 1 - i, length - i))) {
                return false;
            }
        }
        return true;
    }

    public Map<Character, Integer> countWord(String input) {

        Map<Character, Integer> map = new HashMap<>();
        for (Character chr : input.toCharArray()) {
            if (Character.isWhitespace(chr))
                continue;
            if (map.containsKey(chr)) {
                map.put(chr, map.get(chr) + 1);
            } else {
                map.putIfAbsent(chr, 1);
            }
        }
        return map;
    }

    public Map<Character, Integer> countWords2(String input) {

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            char chr = input.charAt(i);
            if (chr != ' ') {
                if (map.containsKey(chr)) {
                    map.put(chr, map.get(chr) + 1);
                } else {
                    map.putIfAbsent(chr, 1);
                }
            }
        }
        return map;
    }

    public char findTheFirstMatchCharacter(String input1, String input2) {

        int minCount = Integer.min(input1.length(), input2.length());
        int index = 0;
        HashSet<Character> set1 = new HashSet<>();
        HashSet<Character> set2 = new HashSet<>();
        while (index < minCount) {
            Character ch1 = input1.charAt(index);
            Character ch2 = input2.charAt(index);
            set1.add(ch1);
            set2.add(ch2);
            if (set1.contains(ch2)) {
                return ch2;
            }
            if (set2.contains(ch1)) {
                return ch1;
            }
            index++;
        }
        while (index < input1.length()) {
            Character ch1 = input1.charAt(index);
            if (set2.contains(ch1)) {
                return ch1;
            }
            set1.add(ch1);
            index++;
        }
        while (index < input1.length()) {
            Character ch2 = input2.charAt(index);
            if (set1.contains(ch2)) {
                return ch2;
            }
            set2.add(ch2);
            index++;
        }
        return 0;
    }

    public boolean findMatch(String line, String match) {

        int j = 0;
        int mLength = match.length();
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == match.charAt(j)) {
                j++;
                if (j == mLength) {
                    return true;
                }
            } else {
                j = 0;

            }
        }
        return false;
    }

    // Function to print all substring
    public static void SubString(String str, int n) {
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j <= n; j++)

                // Please refer below article for details
                // of substr in Java
                // http://www.geeksforgeeks.org/java-lang-string-substring-java/
                System.out.println(str.substring(i, j));
    }


    public String reverseVowels(String input) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            updateStackWithWovels(stack, ch, null, 0);
        }
        StringBuilder sb = new StringBuilder(input);

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            sb = updateStackWithWovels(stack, ch, sb, i);

        }
        return sb.toString();

    }

    private StringBuilder updateStackWithWovels(Stack<Character> stack, char ch, StringBuilder sb, int idx) {
        switch (ch) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
                if (sb != null) {
                    sb.setCharAt(idx, stack.pop());
                } else {
                    stack.push(ch);
                }
                break;

        }
        return sb;
    }

    public String reverseVowelsWithTwoPointer(String s) {
        if (s == null || s.length() == 0) return s;
        String vowels = "aeiouAEIOU";
        char[] chars = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {

            while (start < end && !vowels.contains(chars[start] + "")) {
                start++;
            }

            while (start < end && !vowels.contains(chars[end] + "")) {
                end--;
            }

            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;

            start++;
            end--;
        }
        return new String(chars);
    }


    public char[] replaceSpaceWithPercentTwenty(String input) {

        int spaceCount = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') spaceCount++;
        }
        int totalCharArraySize = input.length() + spaceCount * 2;
        char[] chars = new char[totalCharArraySize];
        for (int i = input.length() - 1; i >= 0; i--) {
            char ch = input.charAt(i);
            if (ch == ' ') {
                chars[--totalCharArraySize] = '0';
                chars[--totalCharArraySize] = '2';
                chars[--totalCharArraySize] = '%';
            } else {
                chars[--totalCharArraySize] = ch;
            }
        }
        return chars;
    }

    public String compressString(String input) {

        int length = input.length();
        StringBuffer sb = new StringBuffer();
        int j = 1;
        for (int i = 0; i < input.length() - 1; i++) {

            char ch = input.charAt(i);
            if (ch == input.charAt(i + 1)) {
                j++;
            } else {
                sb.append(ch).append(j);
                j = 1;
            }
        }
        if(j > 1) sb.append(input.charAt(length -1)).append(j);
        String compressedString = sb.toString();
        return compressedString.length() > length ? input : compressedString;
    }
}
