// Problem: Smallest Even Multiple
// Link: https://leetcode.com/problems/smallest-even-multiple/description/

// T.C. : O(1)
// S.C. : O(1)

package Miscellaneous;

class Solution {
    public int smallestEvenMultiple(int n) {
        if(n%2==0){
            return n;
        }
        return 2*n;
    }
}
