// Problem: Maximum Difference Between Increasing Elements
// Link: https://leetcode.com/problems/maximum-difference-between-increasing-elements/description/
// Date : 16-June-2025

package POTD;

class Solution {
    public int maximumDifference(int[] nums) {
        int n = nums.length;
        int maxDiff = Integer.MIN_VALUE;
        int min = nums[0];
        for(int i=1; i<n; i++){
            if(min < nums[i]){
                maxDiff = Math.max(maxDiff, nums[i]-min);
            }
            if(nums[i] < min){
                min = nums[i];
            }
        }
        if(maxDiff == Integer.MIN_VALUE){
            return -1;
        }
        return maxDiff;
    }
}