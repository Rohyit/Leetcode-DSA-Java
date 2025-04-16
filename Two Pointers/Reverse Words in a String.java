// Problem: Reverse Words in a String
// Link: https://leetcode.com/problems/reverse-words-in-a-string/description/
// Approach: Two pointer

class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] str = s.trim().split("\\s+");

        for(int i=str.length-1; i>=0; i--){
            sb.append(str[i]).append(" ");
        }

        return sb.toString().trim();
    }
}