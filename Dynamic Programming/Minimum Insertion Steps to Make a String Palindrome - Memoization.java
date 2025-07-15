// Problem: Minimum Insertion Steps to Make a String Palindrome
// Link: https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/
// Approach: DP - Memoization

import java.util.*;

class Solution {
    public int minInsertions(String s) {
        StringBuilder sb = new StringBuilder(s);
        String s2 = sb.reverse().toString();
        int n1 = s.length();
        int n2 = s2.length();

        int[][] dp = new int[n1][n2];

        for(int i=0; i<n1; i++){
            Arrays.fill(dp[i], -1);
        }

        int lps =  lcs(n1-1, n2-1, s, s2, dp);

        return n1 - lps;
    }
    private int lcs(int i1, int i2, String s1, String s2, int[][] dp){
        if(i1 == -1 || i2 == -1){
            return 0;
        }

        if(dp[i1][i2] != -1){
            return dp[i1][i2];
        }

        if(s1.charAt(i1) == s2.charAt(i2)){
            return dp[i1][i2] = 1 + lcs(i1 - 1, i2 - 1, s1, s2, dp);
        }
        else{
            return dp[i1][i2] = 0 + Math.max(lcs(i1-1, i2, s1, s2, dp), lcs(i1, i2-1, s1, s2, dp));
        }
    }
}