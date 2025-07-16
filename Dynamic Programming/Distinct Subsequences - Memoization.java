// Problem: Distinct Subsequences
// Link: https://leetcode.com/problems/distinct-subsequences/description/
// Approach: DP - Memoization

import java.util.*; 

class Solution {
    public int numDistinct(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();

        int[][] dp = new int[n1][n2];

        for(int i=0; i<n1; i++){
            Arrays.fill(dp[i], -1);
        }

        return noOfWays(n1-1, n2-1, s, t, dp);
    }
    private int noOfWays(int i1, int i2, String str1, String str2, int[][] dp){
        if(i2 == -1){
            return 1;
        }
        if(i1 == -1){
            return 0;
        }

        if(dp[i1][i2] != -1){
            return dp[i1][i2];
        }

        if(str1.charAt(i1) == str2.charAt(i2)){
            return dp[i1][i2] = noOfWays(i1-1, i2-1, str1, str2, dp) + noOfWays(i1-1, i2, str1, str2, dp);
        }
        else{
            return dp[i1][i2] = noOfWays(i1-1, i2, str1, str2, dp);
        }
    }
}