// Problem: Fill a Special Grid
// Link: https://leetcode.com/contest/weekly-contest-448/problems/fill-a-special-grid/description/
// Contest : Weekly-448

package Contests;

class Solution {
    public int[][] specialGrid(int N) {
        int n = 1 << N;
        return grid(0, n);
    }
    private int[][] grid(int s, int n){
        if(n==1){
            return new int[][]{{s}};
        }
        int half = n/2;
        int area = half*half;

        int[][] tr = grid(s, half);
        int[][] br = grid(s+area, half);
        int[][] bl = grid(s+2*area, half);
        int[][] tl = grid(s+3*area, half);

        int ans[][] = new int[n][n];

        for(int i=0; i< half; i++){
            for(int j=0; j< half; j++){
                ans[i][j] = tl[i][j];
                ans[i][j+half] = tr[i][j];
                ans[i+half][j] = bl[i][j];
                ans[i+half][j+half] = br[i][j];
            }
        }
        return ans;
    }
}