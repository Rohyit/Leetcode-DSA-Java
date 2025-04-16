// Problem: Find the Highest Altitude
// Link: https://leetcode.com/problems/find-the-highest-altitude/description/
// Approach: Prefix Sum

class Solution {
    public int largestAltitude(int[] gain) {
        int prefixAltitude=0;
        int currentHighest=0;
        for(int g : gain){
            prefixAltitude += g;
            currentHighest = Math.max(prefixAltitude, currentHighest);
        }
        return currentHighest;
    }
}