// Problem: Find the K-th Character in String Game I
// Link: https://leetcode.com/problems/find-the-k-th-character-in-string-game-i/description/
// Date : 03-July-2025

package POTD;

class Solution {
    public char kthCharacter(int k) {
        StringBuilder s = new StringBuilder("a");
        while(s.length() < k){
            int len = s.length();
            for(int i=0; i<len; i++){
                s.append((char)('a'+ ((s.charAt(i) - 'a') + 1) % 26));
            }
        }
        return s.charAt(k-1);
    }
}