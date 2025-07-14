// Problem: Longest Common Subsequence
// Link: https://leetcode.com/problems/longest-common-subsequence/description/
// Approach: DP - Memoization

import java.util.*;

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();

        int[][] dp = new int[n1][n2];

        for(int i=0; i<n1; i++){
            Arrays.fill(dp[i], -1);
        }

        return longestCommonSubseq(n1-1, n2-1, text1, text2, dp);
    }
    private int longestCommonSubseq(int i1, int i2, String text1, String text2, int[][] dp){
        if(i1 == -1 || i2 == -1){
            return 0;
        }

        if(dp[i1][i2] != -1){
            return dp[i1][i2];
        }

        if(text1.charAt(i1) == text2.charAt(i2)){
            return dp[i1][i2] = 1 + longestCommonSubseq(i1-1, i2-1, text1, text2, dp);
        }
        else{
            return dp[i1][i2] = 0 + Math.max(longestCommonSubseq(i1-1, i2, text1, text2, dp), longestCommonSubseq(i1, i2-1, text1, text2, dp));
        }
    }
}