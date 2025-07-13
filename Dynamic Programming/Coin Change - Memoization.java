// Problem: Coin Change
// Link: https://leetcode.com/problems/coin-change/description/
// Approach: DP - Memoization

import java.util.*;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }
        int res = minCoins(n - 1, amount, coins, dp);
        return res >= (int)1e9 ? -1 : res;
    }
    private int minCoins(int i, int target, int[] coins, int[][] dp){
        if(target == 0){
            return 0;
        }
        if(i == 0){
            if(coins[i] <= target && target % coins[i] == 0){
                return target / coins[i];
            }
            else{
                return (int)1e9;
            }
        }

        if(dp[i][target] != -1){
            return dp[i][target];
        }
        int notTake = 0 + minCoins(i-1, target, coins, dp);
        int take = Integer.MAX_VALUE;
        if(coins[i] <= target){
            take = 1 + minCoins(i, target - coins[i], coins, dp);
        }
        return dp[i][target] = Math.min(take, notTake);
    }
}