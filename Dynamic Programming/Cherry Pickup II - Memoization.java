// Problem: Cherry Pickup II
// Link: https://leetcode.com/problems/cherry-pickup-ii/description/
// Approach: DP - Memoization

class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][][] dp = new int[m][n][n];

        for(int i=0; i<m; i++){
            for(int j1 = 0; j1<n; j1++){
                for(int j2 = 0; j2<n; j2++){
                    dp[i][j1][j2] = -1;
                }
            }
        }

        return maxCherries(0, 0, n-1, grid, dp);
    }
    private int maxCherries(int i, int j1, int j2, int[][] grid, int[][][] dp){
        int m = grid.length;
        int n = grid[0].length;
        
        if(j1 < 0 || j1 >= n ||j2 < 0 || j2 >= n){
            return (int)-1e8;
        }
        if(i == m-1){
            if(j1 == j2){
                return grid[i][j1];
            }
            else{
                return grid[i][j1] + grid[i][j2];
            }
        }

        if(dp[i][j1][j2] != -1){
            return dp[i][j1][j2];
        }

        int maxi = (int)-1e8;
        for(int delj1 = -1; delj1 <=1; delj1++){
            for(int delj2 = -1; delj2<=1; delj2++){
                if(j1 == j2){
                    maxi = Math.max(maxi, grid[i][j1] + maxCherries(i+1, j1 + delj1, j2 + delj2, grid, dp));
                }
                else{
                    maxi = Math.max(maxi, grid[i][j1] + grid[i][j2] + maxCherries(i+1, j1 + delj1, j2 + delj2, grid, dp));
                }
            }
        }
        return dp[i][j1][j2] = maxi;
    }
}