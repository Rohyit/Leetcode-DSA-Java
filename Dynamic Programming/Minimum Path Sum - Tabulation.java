// Problem: Minimum Path Sum
// Link: https://leetcode.com/problems/minimum-path-sum/description/
// Approach: DP - Tabulation

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int up = Integer.MAX_VALUE;
                int left = Integer.MAX_VALUE;

                if(i == 0 && j == 0){
                    dp[i][j] = grid[0][0];
                }
                else{
                    if(i > 0){
                        up = dp[i-1][j] + grid[i][j];
                    }
                    if(j > 0){
                        left = dp[i][j-1] + grid[i][j];
                    }
                    dp[i][j] = Math.min(up, left);
                }
            }
        }
        return dp[m-1][n-1];
    }
}