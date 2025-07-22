// Problem: Find First and Last Position of Element in Sorted Array
// Link: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
// Approach: Binary Search - Lower Bound and Upper Bound

// Lower Bound - smallest i >= target
// Upper Bound - smallest i > target

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        
        int low = 0, high = n -1;
        int lb = n;
        int ub = n;
        
        // Lower Bound
        while(low <= high){
            int mid = (low + high) / 2;
            
            if(nums[mid] >= target){
                high = mid - 1;
                lb = mid;
            }
            else{
                low = mid + 1;
            }
        }

        low = 0;
        high = n-1;
        
        // Upper Bound 
        while(low <= high){
            int mid = (low + high) / 2;
            
            if(nums[mid] > target){
                high = mid - 1;
                ub = mid;
            }
            else{
                low = mid + 1;
            }
        }

        if(lb == n || nums[lb] != target){
            return new int[] {-1, -1};
        }
        
        return new int[] {lb, ub-1};
    }
}