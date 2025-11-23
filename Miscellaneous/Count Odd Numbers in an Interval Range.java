// Problem: Count Odd Numbers in an Interval Range
// Link: https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/description/

package Miscellaneous;

class Solution {
    public int countOdds(int low, int high) {
        if((high - low + 1) % 2 != 0){
            if(high % 2 == 0){
                return (high - low) / 2;
            }
            return (high - low) / 2 + 1;
        }
        else{
            return (high - low) / 2 + 1;
        }
    }
}