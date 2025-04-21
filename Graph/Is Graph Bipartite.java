// Problem: Is Graph Bipartite
// Link: https://leetcode.com/problems/is-graph-bipartite/description/
// Approach: Graph 

package Graph;
import java.util.*;

class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int color[] = new int[n];
        for(int i=0; i<n; i++){
            color[i]=-1;
        }
        for(int i=0; i<n; i++){
            if(color[i]==-1){
                if(check(i, n, graph, color)==false){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean check(int start, int n, int[][] graph, int[] color){
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        color[start]=0;

        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();

            for(int i : graph[node]){
                if(color[i]==-1){
                    color[i]= 1-color[node];
                    q.add(i);
                }

                else if(color[i]==color[node]){
                    return false;
                }
            }
        }
        return true;
    }
}