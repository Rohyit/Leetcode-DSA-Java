// Problem: Unique Paths
// Link: https://leetcode.com/problems/unique-paths/
// Approach: DP - Memoization

class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                dp[i][j] = -1;
            }
        }
        return noOfPaths(m-1, n-1, dp);
    }
    private int noOfPaths(int i, int j, int[][] dp){
        if(i < 0 || j < 0){
            return 0;
        }
        if(i == 0 && j == 0){
            return 1;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int up = noOfPaths(i-1, j, dp);
        int left = noOfPaths(i, j-1, dp);
        
        return dp[i][j] = up + left;
    }
}