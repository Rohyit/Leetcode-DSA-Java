// Problem: Minimum Cost to Cut a Stick
// Link: https://leetcode.com/problems/minimum-cost-to-cut-a-stick/description/
// Approach: DP - Memoization

import java.util.*; 

class Solution {
    public int minCost(int n, int[] cuts) {
        int len = cuts.length;
        List<Integer> list = new ArrayList<>(); // We will have to add 0 and n to the array before using recursion.
        list.add(0);
        for(int i=0; i<len; i++){
            list.add(cuts[i]);
        }
        list.add(n);

        int[] arr = new int[len+2]; // this is the new hypothetical array 
        for(int i=0; i<len+2; i++){
            arr[i] = list.get(i);
        }
        int length = arr.length;
        Arrays.sort(arr); // sorting the array first is important to use partition DP in order to solve subproblems independently

        int[][] dp = new int[length][length];
        for(int i=0; i<length; i++){
            Arrays.fill(dp[i], -1);
        }

        return minCost(1, length-2, arr, dp); // length-2 is basically n-1 in original array.
    }
    private int minCost(int i, int j, int[] cuts, int[][] dp){
        int n = cuts.length;
        
        // Base Case
        if(i>j){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int mini = Integer.MAX_VALUE;
        for(int ind = i; ind <=j; ind++){

            // cost if the stick is cut at ind is : cuts[j+1] - cuts[i-1]
            int cost = cuts[j+1] - cuts[i-1] + minCost(i, ind - 1, cuts, dp) + minCost(ind + 1, j, cuts, dp);
            mini = Math.min(cost, mini);
        }

        return dp[i][j] = mini;
    }
}