// Problem: Number of Ways to Assign Edge Weights I
// Link: https://leetcode.com/contest/biweekly-contest-157/problems/number-of-ways-to-assign-edge-weights-i/description/
// Contest : Bi-Weekly-157

package Contests;
import java.util.*;

class Solution {
    private List<List<Integer>> tree;
    private int maxDepth = -1;
    private int currDepth = 0;
    private static final int mod = 1_000_000_007;
    
    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<=n; i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        this.tree = adjList;

        dfs(1, -1, 0);

        if(currDepth == 0){
            return 0;
        }
        return power(2, currDepth-1);
    }
    public void dfs(int node, int parent, int depth){
        if(depth > maxDepth){
            maxDepth = depth;
            currDepth = depth;
        }
        for(int neigh : tree.get(node)){
            if(neigh != parent){
                dfs(neigh, node, depth+1);
            }
        }
    }
    private int power(int base, int exp){
        long res = 1, b = base;
        while(exp > 0){
            if((exp & 1) == 1){
                res = (res * b) % mod;
            }
            b = (b * b) % mod;
            exp >>= 1;
        }
        return (int)res;
    }
}