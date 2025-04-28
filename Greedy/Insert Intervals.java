// Problem: Insert Interval
// Link: https://leetcode.com/problems/insert-interval/description/
// Approach: Greedy 

package Greedy;
import java.util.*;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int n = intervals.length;
        int i=0;

        // Left Part
        while(i<n && intervals[i][1]< newInterval[0]){
            list.add(intervals[i]);
            i++;
        }

        // Intersecting Part
        while(i<n && intervals[i][0]<= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        list.add(newInterval);

        // Right Part
        while(i<n){
            list.add(intervals[i]);
            i++;
        }

        return list.toArray(new int[list.size()][]);
    }
}