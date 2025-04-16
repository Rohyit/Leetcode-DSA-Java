// Problem: Maximum Average Subarray
// Link: https://leetcode.com/problems/maximum-average-subarray-i/
// Approach: Sliding Window

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double windowSum=0;

        for(int i=0; i<k; i++){
            windowSum += nums[i];
        }
        double maxAverage = windowSum/k;

        for(int i = k; i<nums.length; i++){
            windowSum += nums[i] - nums[i-k];
            maxAverage = Math.max(maxAverage, windowSum/k);
        }
        return maxAverage;
    }
}