// Problem: Minimum Falling Path Sum
// Link: https://leetcode.com/problems/minimum-falling-path-sum/description/
// Approach: DP - Tabulation

// Memoization would give TLE.

import java.util.*;

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }
        
        for(int j=0; j<n; j++){
            dp[0][j] = matrix[0][j];
        }

        for(int i=1; i<n; i++){
            int up = Integer.MAX_VALUE;
            int rdiag = Integer.MAX_VALUE;
            int ldiag = Integer.MAX_VALUE;
            for(int j=0; j<n; j++){
                up = matrix[i][j] + dp[i-1][j];
                if(j + 1 < n){
                    rdiag = matrix[i][j] + dp[i-1][j+1];
                }
                if(j - 1 >= 0){
                    ldiag = matrix[i][j] + dp[i-1][j-1];
                }

                dp[i][j] = Math.min(up, Math.min(rdiag, ldiag));
            }
        }
        int mini = dp[n-1][0];
        for(int j=1; j<n; j++){
            mini = Math.min(mini, dp[n-1][j]);
        }
        return mini;
    }
}