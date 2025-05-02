// Problem: Subarrays with K Distinct Integers
// Link: https://leetcode.com/problems/subarrays-with-k-different-integers/description/
// Approach: Sliding Window

import java.util.*;

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return count(nums, k)- count(nums, k-1);
    }
    private int count(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();
        int l=0, r=0, count = 0;
        int n = nums.length;

        while(r<n){
            map.put(nums[r], map.getOrDefault(nums[r], 0)+1);

            while(map.size()>k){
                map.put(nums[l], map.get(nums[l])-1);

                if(map.get(nums[l])==0){
                    map.remove(nums[l]);
                }
                l++;
            }
            count += r-l+1;
            r++;
        }
        return count;
    }
}