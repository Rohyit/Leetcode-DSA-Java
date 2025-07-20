// Problem: Burst Balloons
// Link: https://leetcode.com/problems/burst-balloons/description/
// Approach: DP - Memoization

// Note : Revise Min Cost to Cut a stick Problem before this

import java.util.*; 

class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>(); 
        list.add(1);
        for(int i=0; i<n; i++){
            list.add(nums[i]);
        }
        list.add(1);

        int[] arr = new int[n+2]; 
        for(int i=0; i<n+2; i++){
            arr[i] = list.get(i);
        }
        int length = arr.length;

        int[][] dp = new int[length][length];
        for(int i=0; i<length; i++){
            Arrays.fill(dp[i], -1);
        }
        
        return maximumCoins(1, length-2, arr, dp);
    }
    private int maximumCoins(int i, int j, int[] arr, int[][] dp){
        if(i > j){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int maxi = Integer.MIN_VALUE;
        for(int ind = i; ind <= j; ind++){
            int cost = arr[i-1] * arr[ind] * arr[j+1] + maximumCoins(i, ind-1, arr, dp) + maximumCoins(ind+1, j, arr, dp);
            maxi = Math.max(cost, maxi);
        }
        return dp[i][j] = maxi;
    }
}