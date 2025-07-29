// Problem: Split Array Largest Sum
// Link: https://leetcode.com/problems/split-array-largest-sum/
// Approach: Binary Search 

class Solution {
    public int splitArray(int[] nums, int k) {
        int maxi = 0;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            maxi = Math.max(maxi, nums[i]);
            sum += nums[i];
        }

        int low = maxi;
        int high = sum;

        while(low <= high){
            int mid = (low + high) / 2;

            if(canSplit(nums, k, mid)){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }
    private boolean canSplit(int[] nums, int k, int maxSumAllowed){
        int subArrays = 1;
        int currSum = 0;

        for(int i=0; i< nums.length; i++){
            if(currSum + nums[i] > maxSumAllowed){
                subArrays++;
                currSum = nums[i];

                if(subArrays > k){
                    return false;
                }
            }
            else{
                currSum += nums[i];
            }
        }
        return true;
    }
}