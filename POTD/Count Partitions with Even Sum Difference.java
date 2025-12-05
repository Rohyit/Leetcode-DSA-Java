// Problem: Count Partitions with Even Sum Difference
// Link: https://leetcode.com/problems/count-partitions-with-even-sum-difference/description/
// Date : 05-Dec-2025

package POTD;

class Solution {
    public int countPartitions(int[] nums) {
        int totalSum = 0;
        for(int i=0; i<nums.length; i++){
            totalSum += nums[i];
        }
        if(totalSum % 2 == 0){
            return nums.length - 1;
        }
        return 0;
    }
}