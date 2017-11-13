package com.elrast;


import java.util.Arrays;

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
            for (int j = 0; j < input.length - 1; j++) {
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

    public int[] mergeSort(int[] input) {

        if (input.length == 1) {
            return input;
        }
        int half = input.length / 2;
        int[] left = Arrays.copyOfRange(input, 0, half);
        int[] right = Arrays.copyOfRange(input, half, input.length);
        left = mergeSort(left);
        right = mergeSort(right);
        return mergeOrder2(left, right);
    }

    private int[] mergeOrder(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];

        int i = 0;
        int j = 0;
        int currentIndex = 0;
        while (currentIndex < result.length) {
            if (j >= right.length) {
                result[currentIndex] = left[i];
                i++;
            } else if (i >= left.length) {
                result[currentIndex] = right[j];
                j++;
            } else if (left[i] < right[j]) {
                result[currentIndex] = left[i];
                i++;
            } else if (left[i] >= right[j]) {
                result[currentIndex] = right[j];
                j++;
            }
            currentIndex++;
        }
        return result;
    }

    private int[] mergeOrder2(int[] left, int[] right) {

        int[] result = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            result[k++] = left[i] < right[j] ? left[i++] : right[j++];
        }
        while (i < left.length) {
            result[k++] = left[i++];
        }
        while (j < right.length) {
            result[k++] = right[j++];
        }
        return result;

    }
}


