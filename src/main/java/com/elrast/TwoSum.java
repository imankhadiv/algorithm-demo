package com.elrast;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {


    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length; i++) {
            int num = nums[i];
            int neededNum = target - num;
            if(map.containsKey(neededNum)){
                int idx = map.get(neededNum);
                return new int[]{idx, i};
            }else{
                map.put(num, i);
            }
        }
        return null;
    }

}
