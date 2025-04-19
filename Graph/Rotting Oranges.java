// Problem: Rotting Oranges
// Link: https://leetcode.com/problems/rotting-oranges/
// Approach: Graph 

package Graph;
import java.util.*;

class Triplet{
    int row;
    int col;
    int tm;
    Triplet(int row, int col, int tm){
        this.row = row;
        this.col = col;
        this.tm = tm;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Triplet> q = new LinkedList<>();
        int[][] visited = new int[n][m];
        int countFresh = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==2){
                    q.add(new Triplet(i,j,0));
                    visited[i][j]=2;
                }
                else{
                    visited[i][j]=0;
                }
                if(grid[i][j]==1){
                    countFresh++;
                }
            }
        }
        int tm = 0;
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        int count = 0;

        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().tm;
            tm = Math.max(tm, t);
            q.remove();
            for(int i=0; i<4; i++){
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && visited[nrow][ncol]==0 && grid[nrow][ncol]==1){
                    q.add(new Triplet(nrow, ncol, t+1));
                    visited[nrow][ncol]=2;
                    count++;
                }
            }
        }

        if(count != countFresh){
            return -1;
        }
        return tm;
    }
}