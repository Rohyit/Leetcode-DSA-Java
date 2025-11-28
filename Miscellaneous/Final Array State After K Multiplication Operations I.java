// Problem: Final Array State After K Multiplication Operations I
// Link: https://leetcode.com/problems/final-array-state-after-k-multiplication-operations-i/description/

package Miscellaneous;
import java.util.*;

class Solution {
    public int calcMin(int[] nums){
        int mini = Integer.MAX_VALUE;
        int miniIndex = Integer.MAX_VALUE;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] < mini){
                mini = nums[i];
                miniIndex = i;
            }
        }
        return miniIndex;
    }
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        while(k != 0){
            int miniIndex = calcMin(nums);
            nums[miniIndex] *= multiplier;
            k--;
        }
        return nums;
    }
}