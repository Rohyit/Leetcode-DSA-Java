// Problem: Check If All 1's Are at Least Length K Places Away
// Link: https://leetcode.com/problems/check-if-all-1s-are-at-least-length-k-places-away/
// Date : 17-Nov-2025

package POTD;

class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int i = -1;
        for(int j=0; j<nums.length; j++){
            if(nums[j]==1){
                if(i != -1 && j-i-1 < k){
                    return false;
                }
                i = j;
            }
        }
        return true;
    }
}