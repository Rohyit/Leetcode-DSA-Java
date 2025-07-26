// Problem: Find the Smallest Divisor Given a Threshold
// Link: https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/description/
// Approach: Binary Search 

class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int maxi = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            maxi = Math.max(maxi, nums[i]);
        }
        int low = 1;
        int high = maxi;

        while(low <= high){
            int mid = (low + high) / 2;
            if(possible(nums, threshold, mid)){
                high = mid -1;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }
    private boolean possible(int[] nums, int threshold, int num){
        int total = 0;
        for(int i = 0; i< nums.length; i++){
            total += Math.ceil((double)nums[i] / (double)num);
        }
        if(total <= threshold){
            return true;
        }
        else{
            return false;
        }
    }
}