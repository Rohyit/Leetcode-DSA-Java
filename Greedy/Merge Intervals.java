// Problem: Merge Intervals
// Link: https://leetcode.com/problems/merge-intervals/description/
// Approach: Intervals 

package Greedy;
import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();

        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);

        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int[] i : intervals){
            if(i[0]<=end){
                end = Math.max(end, i[1]);
            }
            else{
                list.add(new int[]{start, end});
                start = i[0];
                end = i[1];
            }
        }
        list.add(new int[]{start, end});
        return list.toArray(new int[0][]);
    }
}