// Problem: Calculate Money in Leetcode Bank
// Link: https://leetcode.com/problems/calculate-money-in-leetcode-bank/description/

package POTD;

class Solution {
    public int totalMoney(int n) {
        int sum = 0;
        int i = 1;
        while(i <= n){
            if(i % 7 == 0){
                sum += i/7 + 6;
                i++;
                continue;
            }
            sum += i/7 + i%7;
            i++;
        }
        return sum;
    }
}