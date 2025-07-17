// Problem: Best Time to Buy and Sell Stock II
// Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
// Approach: DP - Memoization

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[][] dp = new int[n][2];
        for(int i=0; i<n; i++){
            for(int j=0; j<2; j++){
                dp[i][j] = -1;
            }
        }

        return maximumProfit(0, 1, prices, dp);
    }
    private int maximumProfit(int i, int couldBuy, int[] prices, int[][] dp){
        int n = prices.length;

        if(i == n){
            return 0;
        }

        if(dp[i][couldBuy] != -1){
            return dp[i][couldBuy];
        }

        int profit = 0;
        if(couldBuy == 1){
            int buy = -prices[i] + maximumProfit(i+1, 0, prices, dp);
            int notBuy = 0 + maximumProfit(i+1, 1, prices, dp);

            profit = Math.max(buy, notBuy);
        }
        else{
            int sell = prices[i] + maximumProfit(i+1, 1, prices, dp);
            int notSell = 0 + maximumProfit(i+1, 0, prices, dp);

            profit = Math.max(sell, notSell);
        }
        return dp[i][couldBuy] = profit;
    }
}