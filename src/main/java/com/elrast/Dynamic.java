package com.elrast;

public class Dynamic {

    public int maxSubArray(int[] nums) {

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] + Math.max(Integer.MIN_VALUE, dp[i - 1]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}


