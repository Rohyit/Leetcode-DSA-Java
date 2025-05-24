// Problem: Largest Local Values in a Matrix
// Link: https://leetcode.com/problems/largest-local-values-in-a-matrix/description/
// Aprroach : Matrix

package Matrix;

class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] maxLocal = new int[n-2][n-2];
        for(int i=0; i<n-2; i++){
            for(int j=0; j<n-2; j++){
                int maxVal = 0;
                for(int k = i; k<=i+2; k++){
                    for(int l = j; l<=j+2; l++){
                        maxVal = Math.max(maxVal, grid[k][l]);
                    }
                }
                maxLocal[i][j] = maxVal;
            }
        }
        return maxLocal;
    }
}