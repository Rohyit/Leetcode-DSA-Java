// Problem: Find Pivot Index
// Link: https://leetcode.com/problems/find-pivot-index/description/
// Approach: Prefix Sum

class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum=0, leftSum = 0;
        for (int num : nums){
            totalSum += num;
        }

        for(int i = 0; i<nums.length; i++){
            if(leftSum == totalSum-leftSum-nums[i]){
                return i;
            }
            leftSum+=nums[i];
        }
        return -1;
    }
}