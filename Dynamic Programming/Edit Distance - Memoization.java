// Problem: Edit Distance
// Link: https://leetcode.com/problems/edit-distance/description/
// Approach: DP - Memoization

class Solution {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();

        int[][] dp = new int[n1][n2];

        for(int i=0; i<n1; i++){
            for(int j=0; j<n2; j++){
                dp[i][j] = -1;
            }
        }

        return minWays(n1-1, n2-1, word1, word2, dp);
    }
    private int minWays(int i1, int i2, String word1, String word2, int[][] dp){
        if(i2 == -1){
            return i1+1;
        }
        if(i1 == -1){
            return i2+1;
        }

        if(dp[i1][i2] != -1){
            return dp[i1][i2];
        }

        if(word1.charAt(i1) == word2.charAt(i2)){
            return 0 + minWays(i1-1, i2-1, word1, word2, dp);
        }
        else{
            int addition = 1 + minWays(i1, i2-1, word1, word2, dp);
            int delete = 1 + minWays(i1-1, i2, word1, word2, dp);
            int replace = 1 + minWays(i1-1, i2-1, word1, word2, dp);

            return dp[i1][i2] = Math.min(addition, Math.min(delete, replace));
        }
    }
}