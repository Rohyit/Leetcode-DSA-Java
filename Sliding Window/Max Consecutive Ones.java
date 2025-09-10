// Problem: Max Consecutive Ones
// Link: https://leetcode.com/problems/max-consecutive-ones/description/
// Approach: Sliding Window

// T.C. : O(n)
// S.C. : O(1)

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = Integer.MIN_VALUE, count = 0;
        for(int right=0; right<nums.length; right++){
            if(nums[right]==1){
                count++;
            }
            else{
                maxCount = Math.max(maxCount, count);
                count=0;
            }
        }
        return Math.max(maxCount, count);
    }
}