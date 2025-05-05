// Problem: Longest Subarray of 1s After Deleting One Element
// Link: https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/description/
// Approach: Sliding Window

class Solution {
    public int longestSubarray(int[] nums) {
        int l=0, r=0, count=0, ans=0;
        int n = nums.length;

        while(r<n){
            if(nums[r]==0){
                count++;
            }
            while(count > 1){
                if(nums[l] == 0){
                    count--;
                }
                l++;
            }
            ans = Math.max(ans, r-l);
            r++;
        }
        return ans;
    }
}