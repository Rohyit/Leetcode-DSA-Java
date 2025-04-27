// Problem: N meetings in one room
// Link: https://www.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1
// Approach: Greedy 

package Greedy;
import java.util.*;

class Solution {
    public int maxMeetings(int start[], int end[]) {
        int n = start.length;
        int[][] meetings = new int[n][2];
        for(int i=0; i<n; i++){
            meetings[i][0] = start[i];
            meetings[i][1] = end[i];
        }
        
        Arrays.sort(meetings, (a,b) -> a[1]-b[1]);
        
        int count = 0;
        int lastEnd = -1;
        
        for(int i=0; i<n; i++){
            if(meetings[i][0]>lastEnd){
                count++;
                lastEnd = meetings[i][1];
            }
        }
        return count;
    }
}
