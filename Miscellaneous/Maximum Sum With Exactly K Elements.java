// Problem: Maximum Sum With Exactly K Elements 
// Link: https://leetcode.com/problems/maximum-sum-with-exactly-k-elements/description/

package Miscellaneous;
import java.util.*;

class Solution {
    public int maximizeSum(int[] nums, int k) {
        int maxNum = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            maxNum = Math.max(maxNum, nums[i]);
        }
        int sum = 0;
        while(k != 0){
            sum += maxNum;
            maxNum += 1;
            k--;
        }
        return sum;
    }
}