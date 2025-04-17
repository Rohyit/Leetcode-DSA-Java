// Problem: Combination Sum II
// Link: https://leetcode.com/problems/combination-sum-ii/
// Approach: Backtracking

package Backtracking;
import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations2(0, candidates, target, list, new ArrayList<>());
        return list;
    }
    public void findCombinations2(int ind, int[] arr, int target, List<List<Integer>> list, List<Integer> ds){
        if(target==0){
            list.add(new ArrayList<>(ds));
            return;
        }

        for(int i=ind; i<arr.length; i++){
            if(i>ind && arr[i]==arr[i-1]){
                continue;
            }
            if(arr[i]>target){
                break;
            }

            ds.add(arr[i]);
            findCombinations2(i+1, arr, target-arr[i], list, ds);
            ds.remove(ds.size()-1);
        }
    }
}