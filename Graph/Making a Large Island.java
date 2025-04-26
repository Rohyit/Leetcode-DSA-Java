// Problem: Making a Large Island
// Link: https://leetcode.com/problems/making-a-large-island/description/
// Approach: Graph 

package Graph;
import java.util.*;

class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findUPar(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u);
        } else {
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU + 1);
        }
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}

class Solution {
    private boolean isValid(int row, int col, int n){
        if(row>=0 && row<n && col>=0 && col<n){
            return true;
        }
        else{
            return false;
        }
    }
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n*n);

        for(int row=0; row<n; row++){
            for(int col=0; col<n; col++){
                if(grid[row][col]==0){
                    continue;
                }
                int[] drow = {-1, 0, 1, 0};
                int[] dcol = {0, 1, 0, -1};
                for(int i=0; i<4; i++){
                    int nrow = row + drow[i];
                    int ncol = col + dcol[i];

                    if(isValid(nrow, ncol, n) && grid[nrow][ncol]==1){
                    int nodeNo = row * n + col;
                    int adjNodeNo = nrow * n + ncol;
                    ds.unionBySize(nodeNo, adjNodeNo);
                    }
                }
            }
        }

        int max = 0;
        for(int row=0; row<n; row++){
            for(int col=0; col<n; col++){
                if(grid[row][col]==1){
                    continue;
                }
                int drow[] = {-1,0,1,0};
                int dcol[] = {0, 1, 0, -1};

                HashSet<Integer> components = new HashSet<>();
                for(int i=0; i<4; i++){
                    int nrow = row + drow[i];
                    int ncol = col + dcol[i];
                    if(isValid(nrow, ncol, n) && grid[nrow][ncol]==1){
                        components.add(ds.findUPar(nrow * n + ncol));
                    }
                }
                int sizeTotal = 0;

                for(Integer parent : components){
                    sizeTotal += ds.size.get(parent);
                }
                max = Math.max(max, sizeTotal+1);
            }
        }

        for(int cellNo=0; cellNo<n*n; cellNo++){
            max = Math.max(max, ds.size.get(ds.findUPar(cellNo)));
        }

        return max;
    }
}