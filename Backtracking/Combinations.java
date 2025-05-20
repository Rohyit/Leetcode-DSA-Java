// Problem: Combinations
// Link: https://leetcode.com/problems/combinations/description/
// Approach: Using Backtracking

package Backtracking;
import java.util.*;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        backtrack(1, ds, list, n, k);
        return list;
    }
    public void backtrack(int start, List<Integer> ds, List<List<Integer>> list, int n, int k){
        if(ds.size() == k){
            list.add(new ArrayList<>(ds));
            return;
        }

        for(int i = start; i<=n; i++){
            ds.add(i);
            backtrack(i+1, ds, list, n, k);
            ds.remove(ds.size()-1);
        }
    }
}