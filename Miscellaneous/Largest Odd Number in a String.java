// Problem: Largest Odd Number in a String
// Link: https://leetcode.com/problems/largest-odd-number-in-string/

package Miscellaneous;

class Solution {
    public String largestOddNumber(String num) {
        for(int i=num.length()-1; i>=0; i--){
            if(num.charAt(i)=='1' || num.charAt(i)=='3' || num.charAt(i)=='5' || num.charAt(i)=='7' || num.charAt(i)=='9' ){
                return num.substring(0, i+1);
            }
        }
        return "";
    }
}