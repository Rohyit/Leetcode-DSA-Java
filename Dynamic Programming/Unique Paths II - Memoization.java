// Problem: Unique Paths II
// Link: https://leetcode.com/problems/unique-paths-ii/
// Approach: DP - Memoization

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int dp[][] = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                dp[i][j] = -1;
            }
        }
        return noOfPaths(m-1, n-1, obstacleGrid, dp);
    }
    private int noOfPaths(int i, int j,int[][] obstacleGrid, int[][] dp){
        if(i>=0 && j>=0 && obstacleGrid[i][j] == 1){
            return 0;
        }
        if(i < 0 || j < 0){
            return 0;
        }
        if(i == 0 && j == 0){
            return 1;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int up = noOfPaths(i-1, j, obstacleGrid, dp);
        int left = noOfPaths(i, j-1, obstacleGrid, dp);
        
        return dp[i][j] = up + left;
    }
}