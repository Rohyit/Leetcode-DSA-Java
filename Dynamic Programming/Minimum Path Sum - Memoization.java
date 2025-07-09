// Problem: Minimum Path Sum
// Link: https://leetcode.com/problems/minimum-path-sum/description/
// Approach: DP - Memoization

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                dp[i][j] = -1;
            }
        }
        return minimumPath(m-1, n-1, grid, dp);
    }
    private int minimumPath(int i, int j, int[][] grid, int[][] dp){
        if(i == 0 && j == 0){
            return grid[i][j];
        }
        if(i < 0 || j < 0){
            return Integer.MAX_VALUE;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        int up = minimumPath(i-1, j, grid, dp);
        int left = minimumPath(i, j-1, grid, dp);

        if(Math.min(up, left) == Integer.MAX_VALUE){
            dp[i][j] = grid[i][j];
        }
        else{
            dp[i][j] = grid[i][j] + Math.min(up, left);
        }

        return dp[i][j];
    }
}