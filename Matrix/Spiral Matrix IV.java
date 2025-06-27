// Problem: Spiral Matrix IV
// Link: https://leetcode.com/problems/spiral-matrix-iv/description/
// Aprroach : Matrix

package Matrix;
import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] arr = new int[m][n];

        for(int[] row : arr){
            Arrays.fill(row, -1);
        }       

        int mincol = 0;
        int maxcol = n-1;
        int minrow = 0;
        int maxrow = m-1;

        ListNode temp = head;

        while(temp != null){
            for(int c = mincol; c<=maxcol; c++){
                if(temp == null || arr[minrow][c] != -1){
                    return arr;
                }
                arr[minrow][c] = temp.val;
                temp = temp.next;
            }
            for(int r=minrow+1; r<=maxrow; r++){
                if(temp == null || arr[r][maxcol] != -1){
                    return arr;
                }
                arr[r][maxcol] = temp.val;
                temp = temp.next;
            }
            for(int c=maxcol-1; c>=mincol; c--){
                if(temp == null || arr[maxrow][c] != -1){
                    return arr;
                }
                arr[maxrow][c] = temp.val;
                temp = temp.next;
            }
            for(int r=maxrow-1; r>minrow; r--){
                if(temp == null || arr[r][mincol] != -1){
                    return arr;
                }
                arr[r][mincol] = temp.val;
                temp = temp.next;
            }
            minrow++;
            mincol++;
            maxrow--;
            maxcol--;
        }
        return arr;
    }
}