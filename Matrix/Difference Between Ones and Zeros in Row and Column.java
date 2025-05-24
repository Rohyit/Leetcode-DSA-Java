// Problem: Difference Between Ones and Zeros in Row and Column
// Link: https://leetcode.com/problems/difference-between-ones-and-zeros-in-row-and-column/description/
// Aprroach : Matrix

package Matrix;

class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] diff = new int[m][n];

        int[] onesRow = new int[m];
        int[] onesCol = new int[n];

        // diff[i][j] = onesRow[i] + onesCol[j] - zerosRow[i] - zerosCol[j]
        // zerosRow[i] = grid.length - onesRow[i]
        // zerosCol[j] = grid[0].length - onesCol[j]
        // diff[i][j] = onesRow[i] + onesCol[j] - m + onesRow[i] - n + onesCol[j]
        //            = 2*onesRow[i] + 2*onesCol[j] - (m+n)

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    onesRow[i]++;
                    onesCol[j]++;
                }
            }
        }
        for(int i=0; i<m; i++){
            int rowTerm = 2*onesRow[i] - n;
            for(int j=0; j<n; j++){
                diff[i][j] = rowTerm + 2*onesCol[j] - m;
            }
        }
        return diff;
    }
}