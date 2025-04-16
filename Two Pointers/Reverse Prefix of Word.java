// Problem: Reverse Prefix of Word
// Link: https://leetcode.com/problems/reverse-prefix-of-word/description/
// Approach: Two pointer

class Solution {
    public String reversePrefix(String word, char ch) {
        int x = word.indexOf(ch);
        if(x==-1){
            return word;
        }

        StringBuilder str = new StringBuilder(word.substring(0, x+1));
        str.reverse();
        str.append(word.substring(x+1));
        return str.toString();
    }
}