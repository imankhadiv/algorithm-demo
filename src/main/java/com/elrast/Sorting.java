package com.elrast;


import java.util.*;

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

    public int[] quickSort(int[] input) {

        if (input.length <= 1) {
            return input;
        }
        int pivotIndex = input.length / 2;
        int pivotVal = input[pivotIndex];
        for (int i = 0; i < input.length; i++) {
            if ((input[i] < pivotVal && i > pivotIndex) || (input[i] > pivotVal && i < pivotIndex)) {
                int tmp = input[i];
                input[i] = pivotVal;
                input[pivotIndex] = tmp;
                pivotIndex = i;
            }
        }
        int[] less = Arrays.copyOfRange(input, 0, pivotIndex);
        int[] greater = Arrays.copyOfRange(input, pivotIndex + 1, input.length);
        return concatenate(quickSort(less), pivotVal, quickSort(greater));
    }

    private int[] concatenate(int[] less, int pivot, int[] greater) {
        int[] result = new int[less.length + 1 + greater.length];
        for (int i = 0; i < less.length; i++) {
            result[i] = less[i];
        }
        result[less.length] = pivot;
        for (int i = 0; i < greater.length; i++) {
            result[i + less.length + 1] = greater[i];
        }
        return result;
    }

    public int[] insertionSort(int[] input) {

        if (input.length <= 1) {
            return input;
        }
        int unsorted = 1;
        while (unsorted < input.length) {

            int i = unsorted - 1;
            int hold = input[unsorted];
            while (i >= 0 && input[i] > hold) {
                input[i + 1] = input[i--];
            }
            input[i + 1] = hold;
            unsorted++;
        }
        return input;
    }

    public int[] shellSort(int[] input) {

        if (input.length <= 1) {
            return input;
        }
        int gap = input.length / 2;
        while (gap != 0) {
            int current = gap;
            while (current < input.length) {
                int i = current - gap;
                int hold = input[current];

                while (i >= 0 && input[i] > hold) {
                    input[i + gap] = input[i];
                    i -= gap;
                }
                input[i + gap] = hold;
                current += 1;
            }
            gap /= 2;
        }
        return input;
    }

    public String[] makeAnagramSort(String[] input) {

        Map<String, List<String>> map = new LinkedHashMap<>();
        for (String item : input) {

            String sortedString = sortCharsInString(item);
            if (map.containsKey(sortedString)) {
                map.get(sortedString).add(item);
            } else {
                List<String> list = new ArrayList<>();
                list.add(item);
                map.put(sortedString, list);
            }
        }
        System.out.println(map);
        String[] result = new String[input.length];
        int index = 0;
        for (List<String> vals : map.values()) {
            for (String item : vals) {
                result[index++] = item;
            }
        }
        return result;
    }

    private String sortCharsInString(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public int findItemInReturnedSortedInput(int[] input, int item) {

        int start = 0;
        int end = input.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (input[mid] == item) return mid;
            else if (input[start] <= input[mid]) {
                if (item > input[start] && item < input[mid]) {
                    end = mid - 1;
                } else if (input[start] == item) {
                    return start;
                } else {
                    start = mid + 1;
                }
            } else {
                if (item > input[mid] && item < input[end]) {
                    start = mid + 1;
                } else if (input[end] == item) {
                    return end;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

}


