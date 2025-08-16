// Problem: Remove Duplicates from Sorted Array II
// Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/
// Approach: Two pointer

// T.C. : O(n)
// S.C. : O(1)

class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n <= 2){
            return n;
        }
        int slow = 2;
        for(int fast = 2; fast < n ; fast++){
            if(nums[fast] != nums[slow - 2]){
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow; 
    }
}