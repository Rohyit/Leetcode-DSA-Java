// Problem: Best Time to Buy and Sell Stock III
// Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/
// Approach: DP - Memoization

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[][][] dp = new int[n][2][3];
        for(int i=0; i<n; i++){
            for(int j=0; j<2; j++){
                for(int k=0; k<3; k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        return maximumProfit(0, 1, 2, prices, dp);
    }
    private int maximumProfit(int i, int couldBuy, int transactionsLeft, int[] prices, int[][][] dp){
        int n = prices.length;
        if(i == n || transactionsLeft == 0){
            return 0;
        }

        if(dp[i][couldBuy][transactionsLeft] != -1){
            return dp[i][couldBuy][transactionsLeft];
        }
        int profit = 0;
        if(couldBuy == 1){
            int buy = -prices[i] + maximumProfit(i+1, 0, transactionsLeft, prices, dp);
            int notBuy = 0 + maximumProfit(i+1, 1, transactionsLeft, prices, dp);

            profit = Math.max(buy, notBuy);
        }
        else{
            int sell = prices[i] + maximumProfit(i+1, 1, transactionsLeft - 1, prices, dp);
            int notSell = 0 + maximumProfit(i+1, 0, transactionsLeft, prices, dp);

            profit = Math.max(sell, notSell);
        }
        return dp[i][couldBuy][transactionsLeft] = profit;
    }
}