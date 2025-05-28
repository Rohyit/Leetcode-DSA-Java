// Problem: Max Area of Island
// Link: https://leetcode.com/problems/max-area-of-island/
// Approach: Graph 

package Graph;
import java.util.*;

class Pair{
    int first;
    int second;

    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        int maxArea = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(visited[i][j]==0 && grid[i][j]==1){
                    int area = bfs(i, j, visited, grid);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }

    private int bfs(int i, int j, int[][] visited, int[][] grid){
        visited[i][j] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, j));
        int n = grid.length;
        int m = grid[0].length;
        int area = 1;

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();

            for(int x = 0; x<4; x++){
                int nrow = row + delRow[x];
                int ncol = col + delCol[x];

                if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && grid[nrow][ncol]==1 && visited[nrow][ncol]==0){
                    visited[nrow][ncol]=1;
                    q.add(new Pair(nrow, ncol));
                    area++;
                }
            }
        }
        return area; 
    }
}