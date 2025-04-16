// Problem: Subarray Product Less Than K
// Link: https://leetcode.com/problems/subarray-product-less-than-k/description/
// Approach: Sliding Window

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0, left=0, product=1;
        for(int right=0; right<nums.length; right++){
            product *= nums[right];

            while(product>= k && left<=right){
                product /= nums[left];
                left++;
            }

            count += right-left+1;
        }
        return count;
    }
}