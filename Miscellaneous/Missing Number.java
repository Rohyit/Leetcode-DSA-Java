// Problem: Missing Number
// Link: https://leetcode.com/problems/missing-number/

// T.C. : O(n)
// S.C. : O(1)

package Miscellaneous;

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int total = n*(n+1)/2;
        int sum = 0;
        for(int i=0; i<n; i++){
            sum += nums[i];
        }
        return total - sum;
    }
}
