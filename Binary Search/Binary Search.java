// Problem: Binary Search
// Link: https://leetcode.com/problems/binary-search/description/
// Approach: Binary Search


// T.C. : O(logn)
// S.C. : O(1)

class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        int mid = -1;
        while(low <= high){
            mid = (low + high) / 2;
            if(nums[mid] == target){
                return mid;
            }
            else if(target > nums[mid]){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }
}