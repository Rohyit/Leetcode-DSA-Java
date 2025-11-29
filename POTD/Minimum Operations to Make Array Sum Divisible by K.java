// Problem: Minimum Operations to Make Array Sum Divisible by K
// Link: https://leetcode.com/problems/minimum-operations-to-make-array-sum-divisible-by-k/
// Date : 29-Nov-2025

package POTD;
import java.util.*;

class Solution {
    public int minOperations(int[] nums, int k) {
        int sum = 0;
        for(int i = 0; i<nums.length; i++){
            sum += nums[i];
        }
        return sum % k;
    }
}