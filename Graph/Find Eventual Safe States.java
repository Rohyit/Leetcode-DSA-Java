// Problem: Find Eventual Safe States
// Link: https://leetcode.com/problems/find-eventual-safe-states/description/
// Approach: Graph 

package Graph;
import java.util.*;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int N = graph.length;
        List<List<Integer>> adjRev = new ArrayList<>();
        for(int i=0; i< N; i++){
            adjRev.add(new ArrayList<>());
        }
        int indegree[] = new int[N];
        for(int i=0; i<N;i++){
            for(int j : graph[i]){
                adjRev.get(j).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        for(int i=0; i<N; i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            ans.add(node);

            for(int i : adjRev.get(node)){
                indegree[i]--;
                if(indegree[i]==0){
                    q.add(i);
                }
            }
        }

        Collections.sort(ans);
        return ans;
    }
}