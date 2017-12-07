package com.elrast.leetcode;

public class AddBinary {

    public String addBinary(String a, String b) {

        if ((a == null || a.isEmpty()) && (b == null || b.isEmpty())) return "";
        if (a == null || a.isEmpty()) return b;
        if (b == null || b.isEmpty()) return a;


        int aIdx = a.length() - 1;
        int bIdx = b.length() - 1;
        int sum = 0;
        String result = "";
        int carrier;

        while (aIdx >= 0 || bIdx >= 0 || sum == 1) {

            if (aIdx > -1) {
                sum += (a.charAt(aIdx--) - '0');
            }
            if (bIdx > -1) {
                sum += (b.charAt(bIdx--) - '0');
            }
            if (sum > 0) {
                result = (sum % 2) + result;
            }else {
                result = '0' + result;
            }
            sum = sum / 2;
        }
        return result;
    }
}
