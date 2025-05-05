// Problem: Frequency of the Most Frequent Element
// Link: https://leetcode.com/problems/frequency-of-the-most-frequent-element/
// Approach: Sliding Window

import java.util.*;
class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int l=0, r=0, n = nums.length;
        long ans = 0; 
        long sum = 0;

        while(r<n){
            sum += nums[r];

            while((long)(r-l+1) * nums[r] - sum > k){
                sum -= nums[l];
                l++;
            }

            ans = Math.max(ans, r-l+1);
            r++;
        }
        return (int)ans;
    }
}