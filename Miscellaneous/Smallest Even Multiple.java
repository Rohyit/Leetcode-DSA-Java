// Problem: Smallest Even Multiple
// Link: https://leetcode.com/problems/smallest-even-multiple/description/

package Miscellaneous;

class Solution {
    public int smallestEvenMultiple(int n) {
        if(n%2==0){
            return n;
        }
        return 2*n;
    }
}
