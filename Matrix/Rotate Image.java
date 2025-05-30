
// Problem: Rotate Image
// Link: https://leetcode.com/problems/rotate-image/description/
// Approach: Matrix

package Matrix;

class Solution {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reverseCols(matrix);
    }
    private void transpose(int[][] matrix){
        for(int i=0; i<matrix.length; i++){
            for(int j = i; j<matrix[0].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    private void reverseCols(int[][] matrix){{
        for(int r=0; r<matrix.length; r++){
            int left=0;
            int right = matrix.length-1;

            while(left<right){
                int temp = matrix[r][left];
                matrix[r][left] = matrix[r][right];
                matrix[r][right] = temp;

                left++;
                right--;
            }
        }
    }
        
    }
}