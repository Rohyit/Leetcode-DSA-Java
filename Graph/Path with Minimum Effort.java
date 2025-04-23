// Problem: Path with Minimum Effort
// Link: https://leetcode.com/problems/path-with-minimum-effort/description/
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
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length, m = heights[0].length;
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>((x,y)->x.first-y.first);

        int[][] maxDiff = new int[n][m];
        for(int[] second : maxDiff){
            Arrays.fill(second, Integer.MAX_VALUE);
        }
        
        maxDiff[0][0]=0;
        pq.add(new Tuple(0,0,0));

        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};

        while(pq.size() != 0){
            Tuple t = pq.poll();
            int diff = t.first, row=t.second, col = t.third;

            if(row == n-1 && col == m-1){
                return diff;
            }

            for(int i=0; i<4; i++){
                int nrow = row + drow[i];
                int ncol = col + dcol[i];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m){
                    int newEffort = Math.max(Math.abs(heights[row][col] - heights[nrow][ncol]), diff);
                    if(newEffort < maxDiff[nrow][ncol]){
                        maxDiff[nrow][ncol]=newEffort;
                        pq.add(new Tuple(newEffort, nrow, ncol));
                    }
                }
            }
        }
        return 0;
    }
}