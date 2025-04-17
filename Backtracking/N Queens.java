// Problem: N Queens
// Link: https://leetcode.com/problems/n-queens/description/
// Approach: Using Backtracking

package Backtracking;
import java.util.*;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        List<String> board = new ArrayList<>();

        String emptyRow = ".".repeat(n);
        for (int i = 0; i < n; i++) {
            board.add(emptyRow);
        }

        int[] leftRow = new int[n];
        int[] lowerDiagonal = new int[2 * n - 1];
        int[] upperDiagonal = new int[2 * n - 1];

        solve(0, board, result, leftRow, lowerDiagonal, upperDiagonal, n);
        return result;
    }

    private void solve(int col, List<String> board, List<List<String>> result,
                       int[] leftRow, int[] lowerDiagonal, int[] upperDiagonal, int n) {
        if (col == n) {
            result.add(new ArrayList<>(board)); 
            return;
        }

        for (int row = 0; row < n; row++) {
            if (leftRow[row] == 0 &&
                lowerDiagonal[row + col] == 0 &&
                upperDiagonal[n - 1 + col - row] == 0) {

                StringBuilder sb = new StringBuilder(board.get(row));
                sb.setCharAt(col, 'Q');
                board.set(row, sb.toString());

                leftRow[row] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[n - 1 + col - row] = 1;

                solve(col + 1, board, result, leftRow, lowerDiagonal, upperDiagonal, n);

                sb.setCharAt(col, '.');
                board.set(row, sb.toString());
                leftRow[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[n - 1 + col - row] = 0;
            }
        }
    }
}
