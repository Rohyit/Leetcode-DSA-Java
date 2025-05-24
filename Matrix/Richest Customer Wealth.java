// Problem: Richest Customer Wealth
// Link: https://leetcode.com/problems/richest-customer-wealth/description/
// Aprroach : Matrix

package Matrix;

class Solution {
    public int maximumWealth(int[][] accounts) {
        int m = accounts.length;
        int n = accounts[0].length;
        int maxWealth = 0;
        for(int i=0; i<m; i++){
            int sum = 0;
            for(int j=0; j<n; j++){
                sum += accounts[i][j];
            }
            if(sum > maxWealth){
                maxWealth = sum;
            }
        }
        return maxWealth;
    }
}