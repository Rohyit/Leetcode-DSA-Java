// Problem: Find Closest Node to Given Two Nodes
// Link: https://leetcode.com/problems/find-closest-node-to-given-two-nodes/description/
// Date : 30-May-2025

package POTD;
import java.util.*;

class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];

        Arrays.fill(dist1, -1);
        Arrays.fill(dist2, -1);

        fillDistances(edges, node1, dist1);
        fillDistances(edges, node2, dist2);

        int minDistance = Integer.MAX_VALUE;
        int ans = -1;

        for(int i=0; i<n; i++){
            if(dist1[i] != -1 && dist2[i] != -1){
                int maxDist = Math.max(dist1[i], dist2[i]);
                if(maxDist < minDistance){
                    minDistance = maxDist;
                    ans = i;
                }
            }
        }
        return ans;
    }
    public void fillDistances(int[] edges, int start, int[] dist){
        boolean[] visited = new boolean[edges.length];
        int distance = 0;
        while(start != -1 && !visited[start]){
            dist[start] = distance;
            visited[start] = true;
            start = edges[start];
            distance++;
        }
    }
}