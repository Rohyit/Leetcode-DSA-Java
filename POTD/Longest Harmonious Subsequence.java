// Problem: Longest Harmonious Subsequence
// Link: https://leetcode.com/problems/longest-harmonious-subsequence/description/
// Date : 30-June-2025

package POTD;
import java.util.*;

class Solution {
    public int findLHS(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int maxLength = 0;
        int l = 0;
        for(int r = 0; r<n; r++){
            while(nums[r] - nums[l] > 1){
                l++;
            }
            if(nums[r] - nums[l] == 1){
                maxLength = Math.max(maxLength, r-l+1);
            }
        }
        return maxLength;
    }
}