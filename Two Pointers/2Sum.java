// Problem: 2Sum
// Link: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
// Approach: Two pointer

// T.C. : O(n)
// S.C. : O(1)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i=1;
        int j=nums.length;
        while(i<j){
            if(nums[i-1]+nums[j-1]==target){
                return new int[]{i, j};
            }
            else if(nums[i-1]+nums[j-1]<target){
                i++;
            }
            else if(nums[i-1]+nums[j-1]>target){
                j--;
            }
        }
        return new int[]{};
    }
}

