// Problem: Longest Common Subsequence
// Link: https://leetcode.com/problems/longest-common-subsequence/description/
// Approach: DP - Tabulation

import java.util.*;

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();

        int[][] dp = new int[n1+1][n2+1];
        
        for(int i=0; i<=n1; i++){
            Arrays.fill(dp[i], -1);
        }

        // For Base Case in Tabulation, we cannot write dp[-1][i2] or dp[i1][-1]. Hence we do right shift of indices i1 and i2 so that we will be able to write dp[0][i2] or dp[i1][0]. Hence we also need to increase the size of dp array to dp[n1+1][n2+1]
        
        for(int i1 = 0; i1 <= n1; i1++){
            dp[i1][0] = 0;
        }
        for(int i2 = 0; i2 <= n2; i2++){
            dp[0][i2] = 0;
        }

        for(int i1 = 1; i1 <= n1; i1++){
            for(int i2 = 1; i2 <= n2; i2++){
                if(text1.charAt(i1-1) == text2.charAt(i2-1)){
                    dp[i1][i2] = 1 + dp[i1-1][i2-1];
                }
                else{
                    dp[i1][i2] = 0 + Math.max(dp[i1-1][i2], dp[i1][i2-1]);
                }
            }
        }
        return dp[n1][n2];
    }
}