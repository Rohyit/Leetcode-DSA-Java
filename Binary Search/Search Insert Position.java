// Problem: Search Insert Position
// Link: https://leetcode.com/problems/search-insert-position/description/
// Approach: Binary Search 

class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int n = nums.length;
        int high = n-1;

        int lb = n;

        while(low <= high){
            int mid = (low + high) / 2;
            
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] >= target){
                high = mid - 1;
                lb = mid;
            }
            else{
                low = mid + 1;
            }
        }
        return lb;
    }
}