// Problem: Number of ways to arrive at destination
// Link: https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/description/
// Approach: Graph 

package Graph;
import java.util.*;

class Pair{
    long first, second;
    Pair(long first, long second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        int m = roads.length;
        for(int i = 0; i<m; i++){
            int u = roads[i][0];
            int v = roads[i][1];
            int wt = roads[i][2];
            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y)->Long.compare(x.first, y.first));
        long[] dist = new long[n];
        long[] ways = new long[n];

        for(int i=0; i<n; i++){
            dist[i] = Long.MAX_VALUE;
            ways[i]=0;
        }
        dist[0]=0;
        ways[0]=1;
        pq.add(new Pair(0, 0));
        int mod = (int)(1e9 + 7);

        while(!pq.isEmpty()){
            long dis = pq.peek().first;
            int node = (int)pq.peek().second;
            pq.remove();

            for(Pair  p : adj.get(node)){
                int adjNode = (int)p.first;
                long edW = p.second;

                if(dis+edW < dist[adjNode]){
                    dist[adjNode]= dis + edW;
                    pq.add(new Pair(dis+edW, adjNode));
                    ways[adjNode] = ways[node];
                }
                else if(dis + edW == dist[adjNode]){
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }
        return (int)ways[n-1];
    }
}