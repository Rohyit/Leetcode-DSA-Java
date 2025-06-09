// Problem: Find Peak Element
// Link: https://leetcode.com/problems/find-peak-element/description/

package Miscellaneous;

class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return 0;
        }
        for(int i = 0; i<n; i++){
            if(i == 0 && nums[i] > nums[i+1]){
                return i;
            }
            else if(i == n-1 && nums[i] > nums[i-1]){
                return i;
            }
            else if(i != 0 && nums[i] > nums[i-1] && nums[i] > nums[i+1]){
                return i;
            }
        }
        return -1;
    }
}