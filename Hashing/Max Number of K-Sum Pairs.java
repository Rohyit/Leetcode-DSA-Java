
// Problem: Max Number of K-Sum Pairs
// Link: https://leetcode.com/problems/max-number-of-k-sum-pairs/description/
// Approach: Hashing

package Hashing;
import java.util.*;

class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int left=0, right=nums.length-1, count=0;
        while(left<right){
            int sum = nums[left]+nums[right];
            if(sum==k){
                count++;
                left++;
                right--;
            }
            else if(sum<k){
                left++;
            }
            else{
                right--;
            }
        }
        return count;
    }
}