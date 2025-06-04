// Problem: Equal Row and Column Pairs
// Link: https://leetcode.com/problems/equal-row-and-column-pairs/
// Approach: Hashing
package Hashing;
import java.util.*;

class Solution {
    public int equalPairs(int[][] grid) {

        // Brute Force - O(n^3) Solution 
        /*
        int n = grid.length;
        int cnt = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                boolean equal = true;
                for(int k = 0; k < n; k++){
                    if(grid[i][k] != grid[k][j]){
                        equal = false;
                        continue;
                    }
                }
                if(equal){
                    cnt++;
                }
            }
        }
        return cnt;
        */

        // Optimized - O(n^2) Solution : 

        int n = grid.length;
        Map<String, Integer> map = new HashMap<>();
        int cnt = 0;

        for(int i = 0; i < n; i++){
            StringBuilder row = new StringBuilder();
            for(int j = 0; j < n; j++){
                row.append(grid[i][j]).append(",");
            }
            String key = row.toString();
            map.put(key, map.getOrDefault(key, 0)+1);
        }

        for(int j = 0; j < n; j++){
            StringBuilder col = new StringBuilder();
            for(int i = 0; i < n; i++){
                col.append(grid[i][j]).append(",");
            }
            String key = col.toString();
            cnt += map.getOrDefault(key, 0);
        }

        return cnt;
    }
}