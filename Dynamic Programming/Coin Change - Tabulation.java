// Problem: Coin Change
// Link: https://leetcode.com/problems/coin-change/description/
// Approach: DP - Tabulation

import java.util.*;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }

        for(int target = 0; target <= amount; target++){
            if(target % coins[0] == 0){
                dp[0][target] = target / coins[0];
            }
            else{
                dp[0][target] = (int)1e9;
            }
        }

        for(int i=1; i<n; i++){
            for(int target = 0; target <= amount; target++){
                int notTake = 0 + dp[i-1][target];
                int take = Integer.MAX_VALUE;
                if(coins[i] <= target){
                    take = 1 + dp[i][target - coins[i]];
                }
                dp[i][target] = Math.min(take, notTake);
            }
        }

        int res = dp[n - 1][amount];
        return res >= (int)1e9 ? -1 : res;
    }
}