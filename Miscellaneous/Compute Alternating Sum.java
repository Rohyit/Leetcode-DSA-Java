// Problem: Compute Alternating Sum
// Link: https://leetcode.com/problems/compute-alternating-sum/description/

package Miscellaneous;
import java.util.*;

class Solution {
    public int alternatingSum(int[] nums) {
        int altSum = 0;
        for(int i=0; i<nums.length; i++){
            if(i % 2 == 0){
                altSum += nums[i];
            }
            else{
                altSum -= nums[i];
            }
        }
        return altSum;
    }
}