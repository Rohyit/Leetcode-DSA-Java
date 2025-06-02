// Problem: Minimum Absolute Difference in Sliding Submatrix
// Link: https://leetcode.com/problems/minimum-absolute-difference-in-sliding-submatrix/
// Contest : Weekly-452

package Contests;
import java.util.*;

class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] ans = new int[m-k+1][n-k+1];

        if(k == 1){
            return ans;
        }

        for(int i=0; i<m-k+1; i++){
            for(int j=0; j<n-k+1; j++){
                List<Integer> list = new ArrayList<>();
                for(int x = i; x < i + k; x++){
                    for(int y = j; y < j + k; y++){
                        if(!list.contains(grid[x][y])){
                            list.add(grid[x][y]);
                        }
                    }
                }
                Collections.sort(list);
                int minVal = Integer.MAX_VALUE;
                
                for(int a = 0; a < list.size() - 1; a++){
                    minVal = Math.min(minVal, Math.abs(list.get(a) - list.get(a + 1)));
                } 

                if(minVal == Integer.MAX_VALUE){
                    minVal = 0;
                }

                ans[i][j] = minVal;
            }
        }
        return ans;
    }
}