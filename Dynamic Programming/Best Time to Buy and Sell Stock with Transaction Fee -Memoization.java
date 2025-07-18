// Problem: Best Time to Buy and Sell Stock with Transaction Fee
// Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/
// Approach: DP - Memoization

class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;

        int[][] dp = new int[n][2];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<2; j++){
                dp[i][j] = -1;
            }
        }
        return maximumProfit(0, 1, prices, fee, dp);
    }
    private int maximumProfit(int i, int couldBuy, int[] prices, int fee, int[][] dp){
        int n = prices.length;

        if(i == n){
            return 0;
        }

        if(dp[i][couldBuy] != -1){
            return dp[i][couldBuy];
        }

        int profit = 0;
        if(couldBuy == 1){
            int buy = -prices[i] + maximumProfit(i+1, 0, prices, fee, dp);
            int notBuy = 0 + maximumProfit(i+1, 1, prices, fee, dp);

            profit = Math.max(buy, notBuy);            
        }
        else{
            int sell = prices[i] - fee + maximumProfit(i+1, 1, prices, fee, dp);
            int notSell = 0 + maximumProfit(i+1, 0, prices, fee, dp);

            profit = Math.max(sell, notSell);
        }
        return dp[i][couldBuy] = profit;
    }
}