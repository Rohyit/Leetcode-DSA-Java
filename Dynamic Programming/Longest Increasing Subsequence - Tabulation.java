// Problem: Longest Increasing Subsequence
// Link: https://leetcode.com/problems/longest-increasing-subsequence/description/
// Approach: DP - Tabulation

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];

        for(int i = n-1; i>=0; i--){
            for(int prev_i = i-1; prev_i >= -1; prev_i--){
                int notTake = 0 + dp[i+1][prev_i + 1];
                int take = 0;
                if(prev_i  == -1 || nums[i] > nums[prev_i]){
                    take = 1 + dp[i+1][i + 1];
                }
                dp[i][prev_i + 1] = Math.max(take, notTake);
            }
        }

        return dp[0][0];
    }
}