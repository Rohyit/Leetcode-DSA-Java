// Problem: Maximum Subarray Sum With Length Divisible by K
// Link: https://leetcode.com/problems/maximum-subarray-sum-with-length-divisible-by-k/description/
// Approach: Prefix Sum

class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long[] minPrefix = new long[k];
        for(int i=0; i<k; i++){
            minPrefix[i] = Long.MAX_VALUE;
        }
        minPrefix[0] = 0;
        long result = Long.MIN_VALUE;
        long total = 0;
        for(int i = 0; i<n; i++){
            total += nums[i];
            int length = i+1;
            int prefix_len = length % k;
            if(minPrefix[prefix_len] != Long.MAX_VALUE){
                result = Math.max(result, total - minPrefix[prefix_len]);
            }
            minPrefix[prefix_len] = Math.min(minPrefix[prefix_len], total);
        }
        return result;
    }
}