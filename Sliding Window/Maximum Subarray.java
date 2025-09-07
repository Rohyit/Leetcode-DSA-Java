// Problem: Maximum Subarray
// Link: https://leetcode.com/problems/max-consecutive-ones/
// Approach: Prefix Sum

// T.C. : O(n)
// S.C. : O(1)

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxSum= Integer.MIN_VALUE, prefixSum=0;
        for(int num: nums){
            prefixSum+=num;
            
            if(prefixSum>maxSum){
                maxSum=prefixSum;
            }
            if(prefixSum<0){
                prefixSum=0;
            }
        }
        return maxSum;
    }
}