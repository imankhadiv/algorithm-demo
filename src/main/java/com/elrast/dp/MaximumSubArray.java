package com.elrast.dp;

public class MaximumSubArray {

    public int maxSubArray(int[] nums) {

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] + Math.max(dp[i - 1],0);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
