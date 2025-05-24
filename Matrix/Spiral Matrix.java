// Problem: Spiral Matrix
// Link: https://leetcode.com/problems/spiral-matrix/description/
// Aprroach : Matrix

package Matrix;
import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        
        int minrow = 0;
        int maxrow = m-1;
        int mincol = 0;
        int maxcol = n-1;

        while(mincol<=maxcol && minrow<=maxrow){
            for(int c=mincol; c<=maxcol; c++){
                int num = matrix[minrow][c];
                list.add(num);
            }
            for(int r=minrow+1; r<=maxrow; r++){
                int num = matrix[r][maxcol];
                list.add(num);
            }
            if(minrow < maxrow){
                for(int c=maxcol-1; c>=mincol; c--){
                    int num = matrix[maxrow][c];
                    list.add(num);
                }
            }
            if(mincol < maxcol){
                for(int r=maxrow-1; r>=minrow+1; r--){
                    int num = matrix[r][mincol];
                    list.add(num);
                }
            }

            minrow++;
            mincol++;
            maxrow--;
            maxcol--;
        }
        return list;
    }
}