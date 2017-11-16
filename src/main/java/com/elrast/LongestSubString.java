package com.elrast;


import java.util.*;

public class LongestSubString {

    public int lengthOfLongestSubstring(String s) {
        if (s.equals("") || s == null) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        Set<Integer> set = new TreeSet<>();
        Set<Character> charSet = new HashSet<>();
        int count = 0;
        boolean flag = false;
        Stack<Character> stack = new Stack<>();
        for (char chr : s.toCharArray()) {
            set.add(-count);
            count = 1;
            if (charSet.contains(chr)) {
                while (!stack.isEmpty()) {
                    if (stack.pop().equals(chr)) {
                        break;
                    }
                    count++;
                }
                flag = false;
            } else {
                charSet.add(chr);
                count++;
                flag = true;
                stack.push(chr);
            }
        }
        if (flag) set.add(-count);
        int finalCount = set.iterator().hasNext() ? set.iterator().next() : 1;
        return -finalCount;

    }

    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

}
