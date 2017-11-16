package com.elrast;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

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

}
