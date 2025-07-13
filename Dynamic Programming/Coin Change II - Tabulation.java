// Problem: Coin Change II
// Link: https://leetcode.com/problems/coin-change-ii/description/
// Approach: DP - Tabulation

import java.util.*;

class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;

        int[][] dp = new int[n][amount+1];

        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }

        for(int target = 0; target <= amount; target++){
            if(target % coins[0] == 0){
                dp[0][target] = 1;
            }
            else{
                dp[0][target] = 0;
            }
        }

        for(int i=1; i<n; i++){
            for(int target=0; target<=amount; target++){
                int notTake = dp[i-1][target];
                int take = 0;
                if(coins[i] <= target){
                    take =dp[i][target - coins[i]];
                }
                dp[i][target] = take + notTake;
            }
        }

        return dp[n-1][amount];
    }
}