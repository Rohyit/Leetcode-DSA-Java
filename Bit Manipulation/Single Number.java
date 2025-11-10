// Problem: Single Number
// Link: https://leetcode.com/problems/single-number/description/
// Approach: Bit Manipulation

// T.C. : O(n)
// S.C. : O(1)

class Solution {
    public int singleNumber(int[] nums) {
        int xor = 0;
        for(int i=0; i<nums.length; i++){
            xor = xor ^ nums[i];
        }
        return xor;
    }
}