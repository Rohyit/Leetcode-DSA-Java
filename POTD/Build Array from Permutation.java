// Problem: Build Array from Permutation
// Link: https://leetcode.com/problems/build-array-from-permutation/description/
// Date : 06-May-2025

package POTD;

class Solution {
    public int[] buildArray(int[] nums) {
/*
        O(n) SPACE ANSWER

        int n = nums.length;
        int[] ans = new int[n];

        for(int i=0; i<n; i++){
            ans[i] = nums[nums[i]];
        }
        return ans;
*/      
        int n = nums.length;
        for(int i=0; i<n; i++){
            nums[i] = nums[i] + (1001 * (nums[nums[i]] % 1001));
        }
        for(int i=0; i<n; i++){
            nums[i] = nums[i] / 1001;
        }
        return nums;
    }
}