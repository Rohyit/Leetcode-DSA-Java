// Problem: Power of 2
// Link: https://leetcode.com/problems/power-of-two/description/
// Approach: Bit Manipulation

class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<=0){
            return false;
        }
        else{
            return (n & (n-1))==0;
        }
    }
}