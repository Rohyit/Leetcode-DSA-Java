// Problem: Count Number of Pairs With Absolute Difference K
// Link: https://leetcode.com/problems/count-number-of-pairs-with-absolute-difference-k/description/

package Miscellaneous;
import java.util.*;

class Solution {
    public int countKDifference(int[] nums, int k) {
        int count = 0;
        for(int i=0; i<nums.length; i++){
            for(int j= i+1; j<nums.length; j++){
                if(Math.abs(nums[i] - nums[j]) == k){
                    count++;
                }
            }
        }
        return count;
    }
}