// Problem: Sum of All Subset XOR Totals
// Link: https://leetcode.com/problems/sum-of-all-subset-xor-totals/description/
// Approach: Bit Manipulation

class Solution {
    public int subsetXORSum(int[] nums) {     
        int or_all = 0;   
        for(int num : nums){
            or_all |= num;
        }
        int multiplier = 1 << (nums.length - 1);
        return or_all * multiplier;
    }
}