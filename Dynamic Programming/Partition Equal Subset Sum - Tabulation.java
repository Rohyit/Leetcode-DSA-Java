// Problem: Partition Equal Subset Sum
// Link: https://leetcode.com/problems/partition-equal-subset-sum/description/
// Approach: DP - Tabulation

class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for(int i=0; i<n; i++){
            totalSum += nums[i];
        }
        if(totalSum % 2 == 1){
            return false;
        }
        int target = totalSum / 2;
        
        boolean[][] dp = new boolean[n][target+1];

        // Base Case 1 (index)
        for(int i=0; i<n; i++){
            dp[i][0] = true;
        }

        // Base Case 2 (target)
        if(nums[0] <= target){
            dp[0][nums[0]] = true;
        }
        for(int i=1; i<n; i++){
            for(int t = 1; t<=target; t++){
                boolean notTake = dp[i-1][t];
                boolean take = false;
                if(t >= nums[i]){
                    take = dp[i-1][t-nums[i]];
                } 
                dp[i][t] = take || notTake;    
            }
        }
        return dp[n-1][target];
    }
}