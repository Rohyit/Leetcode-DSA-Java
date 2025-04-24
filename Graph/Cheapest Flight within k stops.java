// Problem: Cheapest Flight within k stops
// Link: https://leetcode.com/problems/cheapest-flights-within-k-stops/description/
// Approach: Graph 

package Graph;
import java.util.*;

class Pair{
    int first, second;
    Pair(int first, int second){
        this.first=first;
        this.second=second;
    }
}

class Tuple{
    int first, second, third;
    Tuple(int first, int second, int third){
        this.first= first;
        this.second = second;
        this.third = third;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        int m= flights.length;
        for(int i=0; i<m; i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }

        Queue<Tuple> q = new LinkedList<>();
        // Tuple : (stops, node, cost)
        q.add(new Tuple(0, src, 0));
        int[] cost = new int[n];
        for(int i=0; i<n; i++){
            cost[i] = Integer.MAX_VALUE;
        }
        cost[src] = 0;

        while(!q.isEmpty()){
            Tuple t =q.peek();
            q.remove();
            int stops = t.first;
            int node = t.second;
            int costs = t.third;

            if(stops>k){
                continue;
            }
            for(Pair p : adj.get(node)){
                int adjNode = p.first;
                int edW = p.second;

                if(costs + edW <cost[adjNode] && stops<=k){
                    cost[adjNode] = costs + edW;
                    q.add(new Tuple(stops+1, adjNode, costs+edW));
                }
            }
        }
        if(cost[dst] == Integer.MAX_VALUE){
            return -1;
        }
        else{
            return cost[dst];
        }
    }
}