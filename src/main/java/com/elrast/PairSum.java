package com.elrast;


import java.util.HashSet;
import java.util.Set;

public class PairSum {

    public boolean findPairForSortedArray(int[] sortedArray, int sum) {

        int maxIdx = sortedArray.length - 1;
        for (int i = 0; i < sortedArray.length && maxIdx > 0; ) {
            if (sortedArray[i] + sortedArray[maxIdx] == sum) {
                return true;
            } else if (sortedArray[i] + sortedArray[maxIdx] < sum) {
                i++;
            } else {
                maxIdx--;
            }
        }
        return false;
    }

    public boolean findPairForRandomArray(int[] randomArray, int sum) {

        Set<Integer> set = new HashSet<>();
        for (int num : randomArray) {
            if (!set.add(sum - num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
