// Problem: Best Time to Buy and Sell Stock II
// Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
// Approach: Greedy 

package Greedy;

class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0; 
        for(int i=0; i<prices.length-1; i++){
            if(prices[i] < prices[i+1]){
                profit += prices[i+1] - prices[i]; // Greedy Approach : used only on consecutive days. 

            }
        }
        return profit;
    }
}
