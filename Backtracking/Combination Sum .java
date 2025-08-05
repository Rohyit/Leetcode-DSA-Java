// Problem: Combination Sum 
// Link: https://leetcode.com/problems/combination-sum/description/
// Approach: Using Backtracking

// T.C : O(2^n)
// S.C : Auxiliary : O(n)

package Backtracking;
import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        findCombinations(0, candidates, target, list, new ArrayList<>());
        return list;
    }

    public void findCombinations(int i, int[] arr, int target, List<List<Integer>> list, List<Integer> ds){
        if(i==arr.length){
            if(target==0){
                list.add(new ArrayList<>(ds));
            }
            return;
        }
        if(arr[i]<=target){
            ds.add(arr[i]);
            findCombinations(i, arr, target-arr[i], list, ds);
            ds.remove(ds.size()-1);
        }
        findCombinations(i+1, arr, target, list, ds);
    }
}

