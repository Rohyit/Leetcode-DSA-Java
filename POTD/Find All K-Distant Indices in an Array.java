// Problem: Find All K-Distant Indices in an Array
// Link: https://leetcode.com/problems/find-all-k-distant-indices-in-an-array/description/
// Date : 24-June-2025

package POTD;
import java.util.*;

class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(nums[j] == key && Math.abs(i-j) <= k){
                    list.add(i);
                    break;
                }
            }
        }
        return list;
    }
}