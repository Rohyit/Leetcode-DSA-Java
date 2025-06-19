// Problem: Partition Array Such That Maximum Difference Is K
// Link: https://leetcode.com/problems/partition-array-such-that-maximum-difference-is-k/description/
// Date : 19-June-2025

package POTD;
import java.util.*;

class Solution {
    public int partitionArray(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int minVal = nums[0];
        int cnt = 1;
        int i = 0;

        while(i<n){
            if(nums[i] - minVal > k){
                cnt++;
                minVal = nums[i];
            }
            i++;
        }
        return cnt;
    }
}