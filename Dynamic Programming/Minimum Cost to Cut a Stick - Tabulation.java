// Problem: Minimum Cost to Cut a Stick
// Link: https://leetcode.com/problems/minimum-cost-to-cut-a-stick/description/
// Approach: DP - Tabulation

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
        
        for(int i = length-2; i>= 1; i--){
            for(int j = 1; j<= length-2; j++){
                if(i>j){
                    continue;
                }
                int mini = Integer.MAX_VALUE;
                for(int ind = i; ind <=j; ind++){
                    int cost = arr[j+1] - arr[i-1] + dp[i][ind - 1] + dp[ind + 1][j];
                    mini = Math.min(cost, mini);
                }
                dp[i][j] = mini;
            }
        }

        return dp[1][length-2]; 
    }
}