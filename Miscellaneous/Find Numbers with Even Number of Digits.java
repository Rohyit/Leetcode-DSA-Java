// Problem: Find Numbers with Even Number of Digits
// Link: https://leetcode.com/problems/find-numbers-with-even-number-of-digits/

// T.C. : O(n * m)
// S.C. : O(1)

package Miscellaneous;

class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        int digits = 0;
        for(int n : nums){
            while(n>=1){
                n=n/10;
                digits++;
            }
            if(digits % 2 == 0){
                count++;
            }
            digits=0;
        }
        return count;
    }
}