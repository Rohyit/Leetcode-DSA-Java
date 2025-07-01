// Problem: Find the Original Typed String I
// Link: https://leetcode.com/problems/find-the-original-typed-string-i/description/
// Date : 01-July-2025

package POTD;

class Solution {
    public int possibleStringCount(String word) {
        int count = 1;
        for(int i = 1; i<word.length(); i++){
            if(word.charAt(i) == word.charAt(i-1)){
                count++;
            }
        }
        return count;
    }
}
