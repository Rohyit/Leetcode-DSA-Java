// Problem: Find Minimum in Rotated Sorted Array
// Link: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
// Approach: Binary Search 

// T.C. : O(logn)
// S.C. : O(1)

class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        return minimum(nums, n);
    }
    private int minimum(int[] nums, int n){
        int low = 0;
        int high = n-1;

        int min = Integer.MAX_VALUE; // store the minimum of the sorted array and eliminate the sorted part.

        while(low <= high){
            int mid = (low + high) / 2;

            // Left Sorted
            if(nums[low] <= nums[mid]){
                if(nums[low] <= min){
                    min = nums[low];
                }
                low = mid + 1;
            }

            // Right Sorted
            else{
                if(nums[mid] <= nums[high]){
                    min = nums[mid];
                }
                high = mid - 1;
            }
        }
        return min;
    }
}