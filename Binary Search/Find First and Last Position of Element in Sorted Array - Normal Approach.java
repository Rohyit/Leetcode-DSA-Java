// Problem: Find First and Last Position of Element in Sorted Array
// Link: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
// Approach: Binary Search 

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n -1;

        int first = -1;
        int last = -1;

        // For finding first : 
        while(low <= high){
            int mid = (low + high) / 2;

            if(nums[mid] == target){
                first = mid;
                high = mid - 1;
            }

            else if(nums[mid] > target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        low = 0;
        high = n -1;

        // For finding last : 
        while(low <= high){
            int mid = (low + high) / 2;

            if(nums[mid] == target){
                last = mid;
                low = mid + 1;
            }

            else if(nums[mid] > target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return new int[] {first, last};
    }
}