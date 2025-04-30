// Problem: Max Consecutive Ones III
// Link: https://leetcode.com/problems/max-consecutive-ones-iii/description/
// Approach: Sliding Window

class Solution {
    public int longestOnes(int[] nums, int k) {
        int l=0, r=0, zeroes=0, maxLen=0;
        int n = nums.length;

        while(r<n){
            if(nums[r]==0){
                zeroes++;
            }
            if(zeroes>k){
                if(nums[l]==0){
                    zeroes--;
                }
                l++;
            }
            if(zeroes<=k){
                maxLen = Math.max(maxLen, r-l+1);
            }
            r++;
        }
        return maxLen;
    }
}