// Problem: Move Zeroes
// Link: https://leetcode.com/problems/move-zeroes/description/
// Approach: Sliding Window

// T.C. : O(n)
// S.C. : O(1)

class Solution {
    public void moveZeroes(int[] nums) {
        int left=0;
        for(int right=0; right<nums.length; right++){
            if(nums[right]!=0){
                if(left!=right){
                    int temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;
                }
                left++;
            }
        }
    }
}