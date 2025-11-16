// Problem: Number of Substrings With Only 1s
// Link: https://leetcode.com/problems/number-of-substrings-with-only-1s/description/
// Date : 16-Nov-2025

package POTD;

class Solution {
    public int numSub(String s) {
        long total = 0;
        long ones = 0;
        int n = s.length();
        long mod = 1000000007L;

        for(int i=0; i<n; i++){
            if (s.charAt(i) == '1') {
                ones++;
            } else {
                total += ones * (ones + 1) / 2 % mod;
                ones = 0;
            }
        }
        total += ones * (ones + 1) / 2;
        return (int)total;
    }
}