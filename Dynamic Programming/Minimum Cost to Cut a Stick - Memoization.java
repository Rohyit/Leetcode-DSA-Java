// Problem: Minimum Cost to Cut a Stick
// Link: https://leetcode.com/problems/minimum-cost-to-cut-a-stick/description/
// Approach: DP - Memoization

import java.util.*; 

class Solution {
    public int minCost(int n, int[] cuts) {
        int len = cuts.length;
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for(int i=0; i<len; i++){
            list.add(cuts[i]);
        }
        list.add(n);

        int[] arr = new int[len+2];
        for(int i=0; i<len+2; i++){
            arr[i] = list.get(i);
        }
        int length = arr.length;
        Arrays.sort(arr);
        
        int[][] dp = new int[length][length];
        for(int i=0; i<length; i++){
            Arrays.fill(dp[i], -1);
        }

        return minCost(1, length-2, arr, dp);
    }
    private int minCost(int i, int j, int[] cuts, int[][] dp){

        if(i>j){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int mini = Integer.MAX_VALUE;
        for(int ind = i; ind <=j; ind++){
            int cost = cuts[j+1] - cuts[i-1] + minCost(i, ind - 1, cuts, dp) + minCost(ind + 1, j, cuts, dp);
            mini = Math.min(cost, mini);
        }

        return dp[i][j] = mini;
    }
}