// Problem: Max Points you can Obtain from Cards
// Link: https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/description/
// Approach: Sliding Window

class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int lsum = 0, rsum = 0, maxSum = 0;
        
        for(int i=0; i<k; i++){
            lsum = lsum + cardPoints[i];
            maxSum = lsum;
        }

        int rind = cardPoints.length - 1;
        for(int i=k-1; i>=0; i--){
            lsum = lsum - cardPoints[i];
            rsum = rsum + cardPoints[rind];
            rind--;

            maxSum = Math.max(maxSum, lsum+rsum);
        }
        return maxSum;
    }
}