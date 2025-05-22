// Problem: Flipping an Image
// Link: https://leetcode.com/problems/flipping-an-image/
// Aprroach : Matrix

package Matrix;

class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        int[][] res = new int[n][n];
        for(int i = 0; i<n; i++){
            for(int j=0; j<n; j++){
                res[i][j] = image[i][n-j-1];
            }
        }
        for(int i = 0; i<n; i++){
            for(int j=0; j<n; j++){
                if(res[i][j] == 0){
                    res[i][j] = 1;
                }
                else{
                    res[i][j] = 0;
                }
            }
        }
        return res;
    }
}