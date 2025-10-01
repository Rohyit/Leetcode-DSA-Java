// Problem: Water Bottles
// Link: https://leetcode.com/problems/water-bottles/
// Date : 01-October-2025

class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int n = numBottles;
        int m = numExchange;

        int quo = 0;
        int rem = 0;
        int total = n;
        do{
            quo = n/m;
            rem = n%m;
            total += quo;
            rem += quo;
            quo = 0;
            n = rem;
        } while(n >= m);
        return total;
    }
}