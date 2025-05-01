// Problem: Count Number of Nice Subarrays
// Link: https://leetcode.com/problems/count-number-of-nice-subarrays/
// Approach: Sliding Window

// Exactly Same code as that of Binary Subarrays With Sum.

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return countGoal(nums, k) - countGoal(nums, k-1);
    }
    private int countGoal(int[] nums, int goal){
        if(goal<0){
            return 0;
        }
        int l=0, r=0, sum=0, count = 0;
        int n = nums.length;
        while(r<n){
            sum += nums[r] % 2;
            while(sum>goal){
                sum = sum - nums[l] % 2;
                l++;
            }
            count += r-l+1;
            r++;
        }
        return count;
    }
}