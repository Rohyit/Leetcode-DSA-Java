// Problem: Search in Rotated Sorted Array
// Link: https://leetcode.com/problems/search-in-rotated-sorted-array/description/
// Approach: Binary Search 

class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        return searchInRotatedSorted(nums, target, n);
    }
    private int searchInRotatedSorted(int[] nums, int target, int n){
        int low = 0;
        int high = n-1;

        while(low <= high){
            int mid = (low + high) / 2;
            
            if(nums[mid] == target){
                return mid;
            }
            // Left Sorted
            if(nums[low] <= nums[mid]){
                if(nums[low] <= target && target <= nums[mid]){
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }

            // Right Sorted
            else{
                if(nums[mid] <= target && target <= nums[high]){
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}