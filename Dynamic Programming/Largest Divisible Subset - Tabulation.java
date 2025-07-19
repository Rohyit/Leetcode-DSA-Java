// Problem: Longest Divisible Subset
// Link: https://leetcode.com/problems/longest-divisible-subset/description/
// Approach: DP - Tabulation

import java.util.*; 

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<Integer> al = new ArrayList<>();

        int[][] dp = new int[n+1][n+1];

        for(int i = n-1; i>=0; i--){
            for(int prev_i = i-1; prev_i >= -1; prev_i--){
                int notTake = 0 + dp[i+1][prev_i + 1];
                int take = 0;
                if(prev_i  == -1 || nums[i] % nums[prev_i] == 0){
                    take = 1 + dp[i+1][i + 1];
                }
                dp[i][prev_i + 1] = Math.max(take, notTake);
            }
        }
        int i = 0; 
        int prev_i = -1;
        while(i<n){
            int notTake = dp[i+1][prev_i + 1];
            int take = 0;
            if(prev_i == -1 || nums[i] % nums[prev_i] == 0){
                take = 1 + dp[i+1][i+1];
            }
            if(take >= notTake && (prev_i == -1 || nums[i] % nums[prev_i] == 0)){
                al.add(nums[i]);
                prev_i = i;
            }
            i++;
        }

        return al;
    }
}