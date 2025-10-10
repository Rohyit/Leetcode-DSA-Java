// Problem: Set Matrix Zeroes
// Link: https://leetcode.com/problems/set-matrix-zeroes/description/
// Aprroach : Matrix

// T.C. : O(m x n)
// S.C. : O(m + n)

package Matrix;
import java.util.*;

class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> row = new ArrayList<>();
        List<Integer> col = new ArrayList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == 0){
                    row.add(i);
                    col.add(j);
                }
            }
        }
        for(int r : row){
            for(int i=0; i<n; i++){
                matrix[r][i] = 0;
            }
        }
        for(int c : col){
            for(int i=0; i<m; i++){
                matrix[i][c] = 0;
            }
        }
    }
}