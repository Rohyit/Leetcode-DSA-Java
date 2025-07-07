// Problem: Maximum Number of Events That Can Be Attended
// Link: https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/description/
// Date : 07-July-2025

package POTD;
import java.util.*;

class Solution {
    public int maxEvents(int[][] events) {
        int n = events.length;
        Arrays.sort(events, (a,b) -> Integer.compare(a[0], b[0]));
        int day = 0; 
        int maxDays = 0;
        int i=0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while(!pq.isEmpty() || i<n){
            if(pq.isEmpty()){
                day = events[i][0];
            }
            while(i<n && events[i][0] <= day){
                pq.offer(events[i][1]);
                i++;
            }

            pq.poll();
            maxDays++;
            day++;

            while(!pq.isEmpty() && pq.peek() < day){
                pq.poll();
            }
        }
        return maxDays;
    }
}