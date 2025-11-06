// Problem: Smallest Number With All Set Bits
// Link: https://leetcode.com/problems/smallest-number-with-all-set-bits/description/

package Miscellaneous;

class Solution {
    public boolean isSet(int n){
        String str = Integer.toBinaryString(n);
        int len = str.length();
        for(char c : str.toCharArray()){
            if(c == '0'){
                return false;
            }
        }
        return true;
    }
    public int smallestNumber(int n) {
        while(!isSet(n)){
            n++;
        }
        return n;
    }
}