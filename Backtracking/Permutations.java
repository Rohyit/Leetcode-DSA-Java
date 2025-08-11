// Problem: Permutations
// Link: https://leetcode.com/problems/permutations/description/
// Approach: Using Backtracking

// T.C : O(n * n!)

package Backtracking;
import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        recurPermutations(nums, ds, list, freq);
        return list;
        
    }
    public void recurPermutations(int[] arr, List<Integer> ds, List<List<Integer>> list, boolean[] freq){
        if(ds.size()==arr.length){
            list.add(new ArrayList<>(ds));
            return;
        }

        for(int i=0; i<arr.length; i++){
            if(!freq[i]){
                freq[i]= true;
                ds.add(arr[i]);
                recurPermutations(arr, ds, list, freq);
                ds.remove(ds.size()-1);
                freq[i] = false;
            }
        }
    }
}