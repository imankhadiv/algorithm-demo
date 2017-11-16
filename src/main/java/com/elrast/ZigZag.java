package com.elrast;

public class ZigZag {

    public int[] makeZigZagArray(int[] input) {

        boolean flag = true; // a < b
        for (int i = 0; i < input.length - 1; i++) {

            if (flag) {
                if (input[i] > input[i + 1]) {
                    int temp = input[i];
                    input[i] = input[i + 1];
                    input[i + 1] = temp;
                }

            } else {
                if (input[i] < input[i + 1]) {
                    int temp = input[i];
                    input[i] = input[i + 1];
                    input[i + 1] = temp;
                }
            }
            flag = !flag;
        }


        return input;
    }
}
