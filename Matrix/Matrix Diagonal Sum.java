// Problem: Matrix Diagonal Sum
// Link: https://leetcode.com/problems/matrix-diagonal-sum/description/
// Aprroach : Matrix

// T.C. : O(n)
// S.C. : O(1)

package Matrix;

class Solution {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int sum = 0;

        for(int i=0; i<n; i++){
            sum += mat[i][i];
            sum += mat[i][n-1-i];
        }        
        if(n%2 != 0){
            sum -= mat[n/2][n/2];
        }
        return sum;
    }
}