// Problem: 01 Matrix
// Link: https://leetcode.com/problems/01-matrix/description/
// Approach: Graph 

package Graph;
import java.util.*;

class Node{
    int first;
    int second;
    int third;
    Node(int _first, int _second, int _third){
        this.first = _first;
        this.second = _second;
        this.third = _third;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] ans = new int[n][m];
        int[][] visited = new int[n][m];
        Queue<Node> q = new LinkedList<Node>();

        for(int i = 0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j]==0){
                    q.add(new Node(i, j, 0));
                    visited[i][j]=1;
                }
                else{
                    visited[i][j]=0;
                }
            }
        }

        int delRow[] = {-1, 0, 1, 0};
        int delCol[] = {0, 1, 0, -1};

        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            int steps = q.peek().third;
            q.remove();

            ans[row][col]= steps;
            for(int i=0; i<4; i++){
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && visited[nrow][ncol]==0){
                    visited[nrow][ncol]=1;
                    q.add(new Node(nrow, ncol, steps+1));
                }
            }
        }
        return ans;
    }
}