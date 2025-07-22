// Problem: Search in Rotated Sorted Array II
// Link: https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
// Approach: Binary Search 

class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        return searchInRotatedSorted(nums, target, n);
    }
    private boolean searchInRotatedSorted(int[] nums, int target, int n){
        int low = 0;
        int high = n-1;

        while(low <= high){
            int mid = (low + high) / 2;
            
            if(nums[mid] == target){
                return true;
            }

            // Trimming down search space till we can recognize the sorted part of the array.
            if(nums[low] == nums[mid] && nums[mid] == nums[high]){
                low++;
                high--;
            }

            // Left Sorted
            else if(nums[low] <= nums[mid]){
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
        return false;
    }
}