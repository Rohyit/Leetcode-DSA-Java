// Problem: Target Sum
// Link: https://leetcode.com/problems/target-sum/description/
// Approach: DP - Memoization

import java.util.*;

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int totalSum = 0;
        for(int i=0; i <n; i++){
            totalSum += nums[i];
        }
        if(totalSum < Math.abs(target) || (totalSum + target) % 2 != 0){
            return 0;
        }
        int k = (totalSum + target) / 2;

        int[][] dp = new int[n][k+1];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }
        return noOfWays(n-1, k, nums, dp);
    }
    private int noOfWays(int i, int k, int[] nums, int[][] dp){
        if(i == 0){
            if(nums[0] == 0 && k == 0){
                return 2;
            }
            if(k == 0){
                return 1;
            }
            if(k == nums[0]){
                return 1;
            }
            return 0;
        }

        if(dp[i][k] != -1){
            return dp[i][k];
        }
        int notTake = noOfWays(i-1, k, nums, dp);
        int take = 0;
        if(nums[i] <= k){
            take = noOfWays(i-1, k-nums[i], nums, dp);
        }
        return dp[i][k] = take + notTake;
    }
}