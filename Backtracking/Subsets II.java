// Problem: Subsets II
// Link: https://leetcode.com/problems/subsets-ii/description/
// Approach: Using Backtracking

package Backtracking;
import java.util.*;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        findSubsets2(0, nums, list, new ArrayList<>());
        return list;        
    }
    public void findSubsets2(int ind, int[] arr, List<List<Integer>> list, List<Integer> ds){
        list.add(new ArrayList<>(ds));
        
        for(int i=ind; i<arr.length; i++){
            if(i>ind && arr[i]==arr[i-1]){  
                continue;
            }
            ds.add(arr[i]);
            findSubsets2(i+1, arr, list, ds);
            ds.remove(ds.size()-1);
        }
    }
}