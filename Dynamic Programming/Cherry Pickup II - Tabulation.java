// Problem: Cherry Pickup II
// Link: https://leetcode.com/problems/cherry-pickup-ii/description/
// Approach: DP - Tabulation

class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][][] dp = new int[m][n][n];

        for(int j1 = 0; j1<n; j1++){
            for(int j2 = 0; j2<n; j2++){
                if(j1 == j2){
                    dp[m-1][j1][j2] = grid[m-1][j1];
                }
                else{
                    dp[m-1][j1][j2] = grid[m-1][j1] + grid[m-1][j2];
                }
            }
        }
        for(int i= m-2; i>=0; i--){
            for(int j1 = 0; j1<n; j1++){
                for(int j2 = 0; j2<n; j2++){
                    int maxi = (int)-1e8;
                    for(int delj1 = -1; delj1 <=1; delj1++){
                        for(int delj2 = -1; delj2<=1; delj2++){
                            int value = 0;
                            if(j1 == j2){
                                value = grid[i][j1];
                            }
                            else{
                                value = grid[i][j1] + grid[i][j2];
                            }
                            if(j1+delj1 >= 0 && j1+delj1 <n && j2+delj2 >=0 && j2+delj2<n){
                                value += dp[i+1][j1+delj1][j2+delj2];
                            }
                            else{
                                value += (int)-1e8;
                            }
                            maxi = Math.max(maxi, value);
                            dp[i][j1][j2] = maxi;
                        }
                    }
                }
            }
        }
        return dp[0][0][n-1];
    }
}