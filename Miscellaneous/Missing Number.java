// Problem: Missing Number
// Link: https://leetcode.com/problems/missing-number/

package Miscellaneous;

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n*(n+1)/2;
        int sum = 0;
        for(int i=0; i<n; i++){
            sum += nums[i];
        }
        return expectedSum - sum;
    }
}
