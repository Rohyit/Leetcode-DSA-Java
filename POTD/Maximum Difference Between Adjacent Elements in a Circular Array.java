// Problem: Maximum Difference Between Adjacent Elements in a Circular Array
// Link: https://leetcode.com/problems/maximum-difference-between-adjacent-elements-in-a-circular-array/description/
// Date : 12-June-2025

package POTD;

class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int n = nums.length;
        int maxDiff = Integer.MIN_VALUE;
        for(int i=1; i<n; i++){
            int diff = Math.abs(nums[i] - nums[i-1]);
            maxDiff = Math.max(maxDiff, diff);
        }
        maxDiff = Math.max(maxDiff, Math.abs(nums[n-1]-nums[0]));
        return maxDiff;
    }
}