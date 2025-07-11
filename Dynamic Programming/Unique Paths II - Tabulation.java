// Problem: Unique Paths II
// Link: https://leetcode.com/problems/unique-paths-ii/
// Approach: DP - Tabulation

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = 1; // Base Case
        for(int i=0; i<m; i++){
            int up = 0;
            int left = 0;
            for(int j=0; j<n; j++){
                if(i == 0 && j == 0 && obstacleGrid[0][0] != 1){
                    dp[0][0] = 1;
                }
                else if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }
                else{
                    if(i>0){
                        up = dp[i-1][j];
                    }
                    if(j>0){
                        left = dp[i][j-1];
                    }
                    dp[i][j] = up + left;
                }
            }
        }
        return dp[m-1][n-1];
    }
}