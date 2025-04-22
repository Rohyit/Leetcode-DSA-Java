// Problem: Course Schedule 1
// Link: https://leetcode.com/problems/course-schedule/description/
// Approach: Graph 

package Graph;
import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // creating adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int N = numCourses;
        for(int i = 0; i< N; i++){
            adj.add(new ArrayList<>());
        }
        int m = prerequisites.length;
        for(int i=0; i<m; i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
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
        List<Integer> topo = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.peek();

            q.remove();
            topo.add(node);

            for(int i : adj.get(node)){
                indegree[i]--;
                if(indegree[i]==0){
                    q.add(i);
                }
            }
        }
        if(topo.size()==N){
            return true;
        }
        
        return false;
    }
}