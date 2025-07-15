// Problem: Shortest Common Supersequence 
// Link: https://leetcode.com/problems/shortest-common-supersequence/description/
// Approach: DP - Tabulation

import java.util.*; 

class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();

        int[][] dp = new int[n1+1][n2+1];
        
        for(int i=0; i<=n1; i++){
            Arrays.fill(dp[i], -1);
        }
        
        for(int i1 = 0; i1 <= n1; i1++){
            dp[i1][0] = 0;
        }
        for(int i2 = 0; i2 <= n2; i2++){
            dp[0][i2] = 0;
        }

        for(int i1 = 1; i1 <= n1; i1++){
            for(int i2 = 1; i2 <= n2; i2++){
                if(str1.charAt(i1-1) == str2.charAt(i2-1)){
                    dp[i1][i2] = 1 + dp[i1-1][i2-1];
                }
                else{
                    dp[i1][i2] = 0 + Math.max(dp[i1-1][i2], dp[i1][i2-1]);
                }
            }
        }

        String str = "";
        int i1 = n1, i2 = n2;

        while(i1 > 0 && i2 > 0){
            if(str1.charAt(i1 - 1) == str2.charAt(i2 - 1)){
                str += str1.charAt(i1-1);
                i1--;
                i2--;
            }
            else if(dp[i1-1][i2] > dp[i1][i2-1]){
                str += str1.charAt(i1-1);
                i1--;
            }
            else{
                str += str2.charAt(i2-1);
                i2--;
            }
        }

        while(i1 > 0){
            str += str1.charAt(i1-1);
            i1--;
        }

        while(i2 > 0){
            str += str2.charAt(i2-1);
            i2--;
        }

        StringBuilder sb = new StringBuilder(str);
        
        return sb.reverse().toString();
    }
}
