// Problem: Prime In Diagonal
// Link: https://leetcode.com/problems/prime-in-diagonal/
// Aprroach : Matrix

package Matrix;

class Solution {
    public int diagonalPrime(int[][] nums) {
        int n = nums.length;
        int maxNum = 0;
        for(int i=0; i<n; i++){
            if(isPrime(nums[i][i])){
                maxNum = Math.max(maxNum, nums[i][i]);
            }
        }
        for(int i=0; i<n; i++){
            if(isPrime(nums[i][n-i-1])){
                maxNum = Math.max(maxNum, nums[i][n-i-1]);
            }
        }
        return maxNum;
    }
    public boolean isPrime(int num){
        if(num<=1){
            return false;
        }
        for(int i=2; i<=Math.pow(num, 0.5); i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}