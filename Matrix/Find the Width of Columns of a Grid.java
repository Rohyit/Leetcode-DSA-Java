// Problem: Find the Width of Columns of a Grid
// Link: https://leetcode.com/problems/find-the-width-of-columns-of-a-grid/description/
// Aprroach : Matrix

package Matrix;

class Solution {
    public int[] findColumnWidth(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] arr = new int[n];

        for(int j=0; j<n; j++){
            int maxLen = 0;
            for(int i=0; i<m; i++){
                if(String.valueOf(grid[i][j]).length() > maxLen){
                    maxLen = String.valueOf(grid[i][j]).length();
                }
            }
            arr[j] = maxLen;
        }
        return arr;
    }
}