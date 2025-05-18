// Problem: Smallest Index With Digit Sum Equal to Index
// Link: https://leetcode.com/problems/smallest-index-with-digit-sum-equal-to-index/description/
// Contest : Weekly-450

package Contests;

class Solution {
    public int smallestIndex(int[] nums) {
        for(int i=0; i<nums.length; i++){
            int sum=0;
            while(nums[i]>=1){
                int remainder = nums[i] % 10;
                sum += remainder;
                nums[i] /= 10;
            }
            if(sum == i){
                return i;
            }
        }
        return -1;
    }
}