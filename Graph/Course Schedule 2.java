// Problem: Course Schedule 2
// Link: https://leetcode.com/problems/course-schedule-ii/description/
// Approach: Graph 

package Graph;
import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // creating adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int N = numCourses;
        for(int i = 0; i< N; i++){
            adj.add(new ArrayList<>());
        }
        int m = prerequisites.length;
        for(int i=0; i<m; i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        // indegree array 
        int[] indegree = new int[N];
        for(int i=0; i<N; i++){
            for(int j : adj.get(i)){
                indegree[j]++;
            }
        }

        // queue cuz we are using BFS(Kahn's Algo)
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<N; i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        // topo list to store the order
        int[] topo = new int[N];
        int ind = 0;
        while(!q.isEmpty()){
            int node = q.peek();

            q.remove();
            topo[ind++] = node;

            for(int i : adj.get(node)){
                indegree[i]--;
                if(indegree[i]==0){
                    q.add(i);
                }
            }
        }

        if(ind == N){
            return topo;
        }
        int[] arr = {};
        return arr;
    }
}