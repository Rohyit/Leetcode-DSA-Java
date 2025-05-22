// Problem: Row With Maximum Ones
// Link: https://leetcode.com/problems/row-with-maximum-ones/description/
// Aprroach : Matrix

package Matrix;

class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int maxOnes = 0;
        int minRow = 0;

        int m = mat.length;
        int n = mat[0].length;

        for(int i=0; i<m; i++){
            int count = 0;
            for(int j=0; j<n; j++){
                if(mat[i][j] == 1){
                    count++;
                }
            }
            if(count > maxOnes){
                maxOnes = count;
                minRow = i;
            }
        }
        return new int[]{minRow, maxOnes};
    }
}