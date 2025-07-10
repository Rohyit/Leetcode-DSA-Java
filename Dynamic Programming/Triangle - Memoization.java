// Problem: Triangle
// Link: https://leetcode.com/problems/triangle/description/
// Approach: DP - Memoization

// Since there are n different recurrence relations that can be formed if we start from the bottom till the top,
// Hence, we will start from the fixed point which is at the top and our base case will be when we reach last row

import java.util.*;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();

        int[][] dp = new int[m][m];
        for(int i=0; i<m; i++){
            Arrays.fill(dp[i], -1);
        }

        return minimumPath(0, 0, triangle, dp);
    }
    private int minimumPath(int i, int j, List<List<Integer>>triangle, int[][] dp){
        int m = triangle.size();

        if(i == m-1){
            return triangle.get(m-1).get(j);
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int down = triangle.get(i).get(j) + minimumPath(i+1, j, triangle, dp);
        int diag = triangle.get(i).get(j) + minimumPath(i+1, j+1, triangle, dp);

        return dp[i][j] = Math.min(down, diag);
    }
}