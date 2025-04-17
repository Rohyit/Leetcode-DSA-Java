// Problem: Permutations II
// Link: https://leetcode.com/problems/permutations-ii/description/
// Approach: Using Backtracking

package Backtracking;
import java.util.*;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> ds = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        findPermutations(nums, ds, set, freq);
        return new ArrayList<>(set);
    }
    public void findPermutations(int[] arr, List<Integer> ds, Set<List<Integer>> set, boolean[] freq){
        if(ds.size()==arr.length){
            set.add(new ArrayList<>(ds));
            return;
        }
        
        for(int i=0; i<arr.length; i++){
            if(!freq[i]){
                freq[i] = true;
                ds.add(arr[i]);
                findPermutations(arr, ds, set, freq);
                ds.remove(ds.size()-1);
                freq[i] = false;
            }            
        }
    }
}