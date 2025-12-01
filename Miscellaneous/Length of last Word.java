// Problem: Length of Last Word
// Link: https://leetcode.com/problems/length-of-last-word/


package Miscellaneous;

class Solution {
    public int lengthOfLastWord(String s) {
        String str = s.trim();
        int n = str.length();
        int count = 0;
        for(int i = n-1; i>=0; i--){
            if(str.charAt(i) == ' '){
                break;
            }
            count++;
        }
        return count;
    }
}