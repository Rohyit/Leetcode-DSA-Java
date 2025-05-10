// Problem: Minimum Equal Sum of Two Arrays After Replacing Zeros
// Link: https://leetcode.com/problems/minimum-equal-sum-of-two-arrays-after-replacing-zeros/description/
// Date : 10-May-2025

package POTD;

class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0, sum2 = 0;
        int zeroes1 = 0, zeroes2 = 0;
        
        for (int num : nums1) {
            if (num == 0) {
                zeroes1++;
            } else {
                sum1 += num;
            }
        }
        
        for (int num : nums2) {
            if (num == 0) {
                zeroes2++;
            } else {
                sum2 += num;
            }
        }

        if((zeroes1+sum1 < zeroes2+sum2 && zeroes1==0) || (zeroes2+sum2<zeroes1+sum1 && zeroes2==0)){
            return -1;
        }
        return Math.max(sum1+zeroes1, sum2+zeroes2);
    }
}