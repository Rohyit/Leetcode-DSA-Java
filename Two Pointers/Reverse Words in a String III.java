// Problem: Reverse Words in a String III
// Link: https://leetcode.com/problems/reverse-words-in-a-string-iii/description/
// Approach: Two pointer

class Solution {
    public String reverseWords(String s) {
        char[] ch = s.toCharArray();
        int left=0;
        for(int right=0; right<=ch.length; right++){
            if(right==ch.length || ch[right]==' '){
                reverse(ch, left, right-1);
                left=right+1;
            }
        }
        return new String(ch);
    }
    public void reverse(char[] ch, int left, int right){
        while(left<right){
            char temp = ch[left];
            ch[left]=ch[right];
            ch[right]=temp;
            left++;
            right--;
        }
    }
}