// Problem: Coin Change II
// Link: https://leetcode.com/problems/coin-change-ii/description/
// Approach: DP - Memoization

import java.util.*;

class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;

        int[][] dp = new int[n][amount+1];

        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }

        return noOfWays(n-1, amount, coins, dp);
    }
    private int noOfWays(int i, int target, int[] coins, int[][] dp){
        if(i == 0){
            if(target % coins[i] == 0){
                return 1;
            }
            else{
                return 0;
            }
        }

        if(dp[i][target] != -1){
            return dp[i][target];
        }

        int notTake = noOfWays(i-1, target, coins, dp);
        int take = 0;
        if(coins[i] <= target){
            take = noOfWays(i, target - coins[i], coins, dp);
        }
        return dp[i][target] = take + notTake;
    }
}