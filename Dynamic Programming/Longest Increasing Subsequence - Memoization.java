// Problem: Longest Increasing Subsequence
// Link: https://leetcode.com/problems/longest-increasing-subsequence/description/
// Approach: DP - Memoization

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n][n+1];
        for(int i=0; i<n; i++){
            for(int j = 0; j<n+1; j++){
                dp[i][j] = -1;
            }
        }

        return maxLength(0, -1, nums, dp);
    }
    private int maxLength(int i, int prev_ind, int[] nums, int[][] dp){
        int n = nums.length;
        if(i == n){
            return 0;
        }

        if(dp[i][prev_ind + 1] != -1){
            return dp[i][prev_ind + 1];
        }

        int notTake = 0 + maxLength(i+1, prev_ind, nums, dp);
        int take = 0;
        if(prev_ind  == -1 || nums[i] > nums[prev_ind]){
            take = 1 + maxLength(i+1, i, nums, dp);
        }
        return dp[i][prev_ind + 1] = Math.max(take, notTake);
    }
}