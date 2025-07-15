// Problem: Delete Operation for Two Strings
// Link: https://leetcode.com/problems/delete-operation-for-two-strings/description/
// Approach: DP - Memoization

import java.util.*;

class Solution {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();

        int[][] dp = new int[n1][n2];

        for(int i=0; i<n1; i++){
            Arrays.fill(dp[i], -1);
        }

        int lcs = longestCommonSubseq(n1-1, n2-1, word1, word2, dp);
        int deletions = (n1 - lcs) + (n2 - lcs);
        
        return deletions;
    }
    private int longestCommonSubseq(int i1, int i2, String word1, String word2, int[][] dp){
        if(i1 == -1 || i2 == -1){
            return 0;
        }

        if(dp[i1][i2] != -1){
            return dp[i1][i2];
        }

        if(word1.charAt(i1) == word2.charAt(i2)){
            return dp[i1][i2] = 1 + longestCommonSubseq(i1-1, i2-1, word1, word2, dp);
        }
        else{
            return dp[i1][i2] = 0 + Math.max(longestCommonSubseq(i1-1, i2, word1, word2, dp), longestCommonSubseq(i1, i2-1, word1, word2, dp));
        }
    }
}