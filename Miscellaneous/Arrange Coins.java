// Problem: Add Strings
// Link: https://leetcode.com/problems/arrange-coins

package Miscellaneous;

class Solution {
    public int arrangeCoins(int n) {
        return (int)Math.floor(-0.5 + Math.sqrt((double)2*n + 0.25));
    }
}