// Problem: Shortest Path in a Binary Matrix
// Link: https://leetcode.com/problems/shortest-path-in-binary-matrix/description/
// Approach: Graph 

package Graph;
import java.util.*;

class Tuple {
    int first, second, third;
    Tuple(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length, m = grid[0].length;

        if (grid[0][0] == 1 || grid[n - 1][m - 1] == 1) return -1;

        Queue<Tuple> q = new LinkedList<>();
        int[][] dist = new int[n][m];

        for (int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE);

        dist[0][0] = 1;
        q.add(new Tuple(1, 0, 0));

        int[] drow = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dcol = {0, 1, 1, 1, 0, -1, -1, -1};

        while (!q.isEmpty()) {
            Tuple t = q.poll();
            int dis = t.first, row = t.second, col = t.third;

            if (row == n - 1 && col == m - 1) return dis;

            for (int i = 0; i < 8; i++) {
                int nrow = row + drow[i];
                int ncol = col + dcol[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m &&
                    grid[nrow][ncol] == 0 && dis + 1 < dist[nrow][ncol]) {

                    dist[nrow][ncol] = dis + 1;
                    q.add(new Tuple(dis + 1, nrow, ncol));
                }
            }
        }

        return -1;
    }
}
