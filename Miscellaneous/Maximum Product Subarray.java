// Problem: Maximum Product Subarray
// Link: https://leetcode.com/problems/maximum-product-subarray/description/

// T.C. : O(n)
// S.C. : O(1)

package Miscellaneous;

// Variation of Kadane's Algorithm

class Solution {
    public int maxProduct(int[] nums) {
        int currMax = nums[0], currMin = nums[0], maxProd = nums[0];

        for(int i=1; i<nums.length; i++){
            int temp = currMax;
            currMax = Math.max(nums[i], Math.max(currMax * nums[i], currMin * nums[i]));
            currMin = Math.min(nums[i], Math.min(temp * nums[i], currMin * nums[i]));
        
            maxProd = Math.max(maxProd, currMax);
        }  
        return maxProd;
    }
}
