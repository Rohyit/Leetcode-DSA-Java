// Problem: Reverse String
// Link: https://leetcode.com/problems/reverse-string/description/
// Approach: Two pointer

class Solution {
    public void reverseString(char[] s) {
        int left = 0, right = s.length-1;
        while(left<right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}