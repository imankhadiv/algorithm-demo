package com.elrast;

/**
 * Created by Iman on 18/11/17.
 */
public class LongestCommonSubSequence {


    public int find(String s1, String s2) {

        if (s1.length() == 0 || s2.length() == 0) {
            return 0;
        } else {
            if (s1.charAt(s1.length() - 1) == s2.charAt(s2.length() - 1)) {
                return 1 + find(s1.substring(0, s1.length() - 1), s2.substring(0, s2.length() - 1));
            } else {
                return Integer.max(find(s1.substring(0, s1.length() - 1), s2.substring(0, s2.length())), find(s1.substring(0, s1.length()), s2.substring(0, s2.length() - 1)));
            }
        }
    }
}
