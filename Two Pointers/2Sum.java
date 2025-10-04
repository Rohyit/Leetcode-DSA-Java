// Problem: 2Sum
// Link: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
// Approach: Two pointer

// T.C. : O(n)
// S.C. : O(1)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        /*
        // BRUTE FORCE - T.C. : O(n^2)
            int n = nums.length;
            for(int i=0; i<n-1; i++){
                for(int j=i+1; j<n; j++){
                    if(nums[i] + nums[j] == target){
                        return new int[]{i+1, j+1};
                    }
                }
            }
            return new int[]{};
        */
        // OPTIMIZED

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