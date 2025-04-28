// Problem: Non Overlapping Intervals
// Link: https://leetcode.com/problems/non-overlapping-intervals/description/
// Approach: Greedy 

package Greedy;
import java.util.*;

// This Problem is similar to N-meetings in one room. There we were finding max meetings that can be scheduled in a room(obv they will be non-overlapping) and here we are finding minimum number of intervals to remove so that rest of them are non-overlapping.

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals, (a,b) -> a[1]-b[1]);

        int count = 1;
        int lastEnding = intervals[0][1];

        for(int i=1; i<n; i++){
            if(intervals[i][0]>=lastEnding){
                count++;
                lastEnding = intervals[i][1];
            }
        }
        return n-count;
    }
}