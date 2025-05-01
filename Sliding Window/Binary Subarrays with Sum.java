// Problem: Binary Subarrays With Sum
// Link: https://leetcode.com/problems/binary-subarrays-with-sum/description/
// Approach: Sliding Window

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return countGoal(nums, goal) - countGoal(nums, goal-1);
    }
    private int countGoal(int[] nums, int goal){
        if(goal<0){
            return 0;
        }
        int l=0, r=0, sum=0, count = 0;
        int n = nums.length;
        while(r<n){
            sum += nums[r];
            while(sum>goal){
                sum = sum - nums[l];
                l++;
            }
            count += r-l+1;
            r++;
        }
        return count;
    }
}