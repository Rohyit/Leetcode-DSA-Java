// Problem: Remove Duplicates from Sorted Array
// Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
// Approach: Two pointer

class Solution {
    public int removeDuplicates(int[] nums) {
        int left=0;
        if(nums.length==1){
            return 1;
        }
        for(int right=1; right<nums.length; right++){
            if(nums[left]!=nums[right]){
                left++;
                nums[left]=nums[right];
            }
        }
        return left+1;
    }
}