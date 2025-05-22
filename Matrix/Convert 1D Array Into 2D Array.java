// Problem: Convert 1D Array Into 2D Array
// Link: https://leetcode.com/problems/convert-1d-array-into-2d-array/description/
// Aprroach : Matrix

package Matrix;

class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if(m*n != original.length){
            int[][] arr = {};
            return arr;
        }
        int[][] arr = new int[m][n];
        int idx = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = original[idx];
                idx++;
            }
        }
        return arr;
    }
}