// Problem: Binary Search
// Link: https://leetcode.com/problems/binary-search/description/
// Approach: Binary Search - Recursive

class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        return binarySearch(nums, 0, n-1, target);
    }
    private int binarySearch(int[] nums, int low, int high, int target){
        if(low > high){
            return -1;
        }
        int mid = (low+high)/2;
        if(nums[mid] == target){
            return mid;
        }
        else if(nums[mid] > target){
            return binarySearch(nums, low, mid - 1, target);
        }
        else{
            return binarySearch(nums, mid + 1, high, target);
        }
    }
}