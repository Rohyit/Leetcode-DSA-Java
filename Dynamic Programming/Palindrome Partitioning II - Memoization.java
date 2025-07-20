// Problem: Palindrom Partitioning II
// Link: https://leetcode.com/problems/palindrome-partitioning-ii/
// Approach: DP - Memoization

class Solution {
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n];
        for(int i=0; i<n; i++){
            dp[i] = -1;
        }
        return minPartitions(0, s, dp) - 1;
    }
    private int minPartitions(int i, String s, int[] dp){
        int n = s.length();
        if(i == n){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }

        int mini = Integer.MAX_VALUE;
        for(int j=i; j<n; j++){
            if(isPalindrome(i, j, s)){
                int cost = 1 + minPartitions(j+1, s, dp);
                mini = Math.min(cost, mini);
            }
        }
        return dp[i] = mini;
    }
    private boolean isPalindrome(int i, int j, String s){
        boolean flag = true;
        while(i<j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
                continue;
            }
            else{
                return false;
            }
        }
        return flag;
    }
}