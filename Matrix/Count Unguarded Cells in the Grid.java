// Problem: Count Unguarded Cells in the Grid
// Link: https://leetcode.com/problems/count-unguarded-cells-in-the-grid/description/
// Aprroach : Matrix

package Matrix;

class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] area = new int[m][n];
        for (int[] g : guards) {
            area[g[0]][g[1]] = -1;
        }
        for (int[] w : walls) {
            area[w[0]][w[1]] = -2;
        }
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        for (int[] g : guards) {
            for (int[] d : dirs) {
                int x = g[0] + d[0];
                int y = g[1] + d[1];
                while (x >= 0 && x < m && y >= 0 && y < n && area[x][y] != -1 && area[x][y] != -2) {
                    if (area[x][y] == 0) area[x][y] = 1;
                    x += d[0];
                    y += d[1];
                }
            }
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (area[i][j] == 0) count++;
            }
        }
        return count;
    }
}