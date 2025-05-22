// Problem: Find Champion I
// Link: https://leetcode.com/problems/find-champion-i/description/
// Aprroach : Matrix

package Matrix;

class Solution {
    public int findChampion(int[][] grid) {
        int n = grid.length;
        
        int maxSum = Integer.MIN_VALUE;
        int maxInd = -1;

        for(int i=0; i<n; i++){
            int sum = 0;
            for(int j=0; j<n; j++){
                sum += grid[i][j];
            }
            if(sum > maxSum){
                maxSum = sum;
                maxInd = i;
            }
        }
        return maxInd;
    }
}