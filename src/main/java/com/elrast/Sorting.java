package com.elrast;


public class Sorting {


    public int[] sort(int[] input) {

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                if (input[i] < input[j]) {
                    swap(input, i, j);
                }
            }
        }
        return input;
    }

    public int[] bubbleSort(int[] input) {

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length-1; j++) {
                if (input[j] > input[j + 1]) {
                    swap(input, j);
                }
            }
        }
        return input;
    }

    private void swap(int[] input, int i, int j) {
        int temp = input[j];
        input[j] = input[i];
        input[i] = temp;
    }

    private void swap(int[] input, int j) {
        int temp = input[j];
        input[j] = input[j + 1];
        input[j + 1] = temp;
    }
}
