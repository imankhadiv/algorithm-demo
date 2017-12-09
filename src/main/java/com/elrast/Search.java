package com.elrast;

public class Search {


    public boolean findPointRecursively(int[] input, int point) {
        return findPoint(input, point, 0, input.length - 1);
    }

    private boolean findPoint(int[] input, int point, int low, int high) {

        if (high < low) return false;
        int mid = (low + high) / 2;
        if (input[mid] > point) {
            return findPoint(input, point, low, mid - 1);
        } else if (input[mid] < point) {
            return findPoint(input, point, mid + 1, high);
        } else {
            return true;
        }
    }

    public boolean findPointUsingIteration(int[] input, int point) {

        int low = 0;
        int high = input.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (input[mid] < point) {
                low = mid + 1;
            } else if (input[mid] > point) {
                high = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
