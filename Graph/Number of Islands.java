// Problem: Number of Islands
// Link: https://leetcode.com/problems/number-of-islands/description/
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
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        int count = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(visited[i][j]==0 && grid[i][j]=='1'){
                    count++;
                    bfs(i, j, visited, grid);
                }
            }
        }
        return count;
    }
    private void bfs(int i, int j, int[][] visited, char[][] grid){
        visited[i][j] = 1;
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(i, j));
        int n = grid.length;
        int m = grid[0].length;

        int[] delRow = {-1,0,1,0};
        int[] delCol = {0, 1, 0, -1};

        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();
            for(int x = 0; x<4; x++){
                    int nrow = row + delRow[x];
                    int ncol = col + delCol[x];
                    if(nrow >= 0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]=='1' && visited[nrow][ncol]==0){
                        visited[nrow][ncol]=1;
                        q.add(new Pair(nrow, ncol));
                    }
                }
        }
    }
}