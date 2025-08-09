// Problem: Subsets
// Link: https://leetcode.com/problems/subsets/description/
// Approach: Using Backtracking

// T.C. : O(2^n)

package Backtracking;
import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        findSubsets(0, nums, list, new ArrayList<>());
        return list;
    }
    public void findSubsets(int i, int[] arr, List<List<Integer>> list, List<Integer> ds){
        if(i>=arr.length){
            list.add(new ArrayList<>(ds));
            return;
        }
        ds.add(arr[i]);
        findSubsets(i+1, arr, list, ds);
        ds.remove(ds.size()-1);
        findSubsets(i+1, arr, list, ds);
    }
}