package com.elrast;

public class ConvertingStrings {


    public int convertS1ToS2WithMinChange(String s1, String s2) {


        if (s1.length() == 0) {
            return s2.length();
        } else if (s2.length() == 0) {
            return s1.length();
        } else if (s1.charAt(s1.length() - 1) == s2.charAt(s2.length() - 1)) {
            return convertS1ToS2WithMinChange(s1.substring(0, s1.length() - 1), s2.substring(0, s2.length() - 1));
        } else {
            String s1Sub = s1.substring(0, s1.length() - 1);
            String s2Sub = s2.substring(0, s2.length() - 1);
            return 1 + Integer.min(convertS1ToS2WithMinChange(s1Sub, s2Sub), Integer.min(convertS1ToS2WithMinChange(s1, s2Sub), convertS1ToS2WithMinChange(s1Sub, s2)));

        }

    }

    int min(int x, int y, int z) {
        if (x <= y && x <= z) return x;
        if (y <= x && y <= z) return y;
        else return z;
    }

    public int convertS1ToS2WithMinChange2(String s1, String s2) {

        int s1Length = s1.length();
        int s2Length = s2.length();
        int[][] matrix = new int[s1Length + 1][s2Length + 1];

        for (int i = 0; i <= s1Length; i++) {
            for (int j = 0; j <= s2Length; j++) {
                if (i == 0) {
                    matrix[i][j] = j;
                } else if (j == 0) {
                    matrix[i][j] = i;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    matrix[i][j] = matrix[i - 1][j - 1];
                }else {
                    matrix[i][j] = 1 + min(matrix[i][j-1],
                            matrix[i-1][j],
                            matrix[i-1][j-1]);
                }
            }
        }
        return matrix[s1Length][s2Length];

    }


}
