// Problem: Partition Equal Subset Sum
// Link: https://leetcode.com/problems/partition-equal-subset-sum/description/
// Approach: DP - Memoization

import java.util.*;

class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for(int i=0; i<n; i++){
            totalSum += nums[i];
        }
        if(totalSum % 2 == 1){
            return false;
        }
        int target = totalSum / 2;
        int[][] dp = new int[n][target+1];

        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }
        return equalSubset(n-1, target, nums, dp);
    }
    private boolean equalSubset(int i, int target, int[] nums, int[][] dp){
        int n = nums.length;
        
        if(target == 0){
            return true;
        }
        if(i == 0){
            return nums[0] == target;
        }

        if(dp[i][target] != -1){
            return dp[i][target] == 1;
        }

        boolean notTake = equalSubset(i-1, target, nums, dp);
        boolean take = false;
        if(target >= nums[i]){
            take = equalSubset(i-1, target-nums[i], nums, dp);
        }
        dp[i][target] = (take || notTake) ? 1 : 0;
        
        return take || notTake; 
    }
}