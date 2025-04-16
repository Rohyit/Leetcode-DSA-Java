// Problem: Best Time to Buy and Sell Stock
// Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
// Approach: Two pointer

class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int price : prices){
            minPrice = Math.min(minPrice, price);
            int profit = price - minPrice;

            maxProfit = Math.max(maxProfit, profit);
        }
        return maxProfit;
    }
}