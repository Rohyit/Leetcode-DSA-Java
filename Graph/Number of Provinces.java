// Problem: Number of Provinces
// Link: https://leetcode.com/problems/number-of-provinces/description/
// Approach: Graph 

package Graph;
import java.util.*;

class Solution {
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
        int n = isConnected.length;
        
        for(int i = 0; i< n; i++){
            adjList.add(new ArrayList<Integer>());
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(isConnected[i][j]==1 && i != j){
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }

        int[] visited = new int[n];
        int count = 0;

        for(int i = 0; i<n; i++){
            if(visited[i] == 0){
                count++;
                dfs(i, adjList, visited);
            }
        }
        return count;
    }
    public void dfs(int node, ArrayList<ArrayList<Integer>> adjList, int[] visited){
        visited[node] = 1;
        for(Integer i : adjList.get(node)){
            if(visited[i]==0){
                dfs(i, adjList, visited);
            }
        }
    }
}