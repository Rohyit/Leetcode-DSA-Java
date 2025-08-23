// Problem: Rearrange Array Elements by Sign
// Link: https://leetcode.com/problems/rearrange-array-elements-by-sign/description/
// Approach: Two pointer

// T.C. : O(n)
// S.C. : O(n)

class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] arr = new int[nums.length];
        int pos = 0, neg = 1;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] > 0){
                arr[pos] = nums[i];
                pos += 2;
            }
        }
        for(int i = 0; i<nums.length; i++){
            if(nums[i] < 0){
                arr[neg] = nums[i];
                neg += 2;
            }
        }
        return arr;
    }
}