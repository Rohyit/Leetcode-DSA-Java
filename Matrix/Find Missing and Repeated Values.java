// Problem: Find Missing and Repeated Values
// Link: https://leetcode.com/problems/find-missing-and-repeated-values/description/
// Aprroach : Matrix

package Matrix;

class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int duplicate = -1;
        int missing = -1;
        int[] arr = new int[(int)Math.pow(n,2)];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int num = grid[i][j];
                arr[num-1]++;
            }
        }
        for(int i=0; i<arr.length; i++){
            if(arr[i]==0){
                missing = i+1;
            }
            else if(arr[i]==2){
                duplicate = i+1;
            }
        }
        return new int[]{duplicate, missing};
    }
}