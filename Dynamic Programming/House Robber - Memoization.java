// Problem: House Robber
// Link: https://leetcode.com/problems/house-robber/
// Approach: DP - Memoization 

import java.util.*; 

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return recursive(n-1, nums, dp);
    }
    public int recursive(int i, int[] nums, int[] dp){
        if(i == 0){
            return nums[i];
        }
        if(i < 0){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        int rob = nums[i] + recursive(i-2, nums, dp);
        int skip = recursive(i-1, nums, dp);

        return dp[i] = Math.max(rob, skip);
    }
}