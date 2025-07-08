// Problem: House Robber II
// Link: https://leetcode.com/problems/house-robber-ii/
// Approach: DP - Tabulation 


class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return nums[0];
        }

        int option1 = roblinear(0, n-2, nums); // Leaving Last House Unrobbed
        int option2 = roblinear(1, n-1, nums); // Leaving First House Unrobbed
        
        return Math.max(option1, option2);
    }
    private int roblinear(int start, int end, int[] nums){
        int len = end - start + 1;
        if(len == 1){
            return nums[start];
        }
        int[] dp = new int[len];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);

        for(int i = 2; i<len; i++){
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[start + i]);
        }
        return dp[len-1];
    }
}