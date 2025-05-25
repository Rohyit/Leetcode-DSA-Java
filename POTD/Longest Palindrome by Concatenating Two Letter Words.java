// Problem: Longest Palindrome by Concatenating Two Letter Words
// Link: https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words/description/
// Date : 25-May-2025

package POTD;
import java.util.*;

class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        int unpaired = 0; 
        int len = 0;

        for(String s : words){
            if(!map.containsKey(s)){
                map.put(s, 0);
            }
            if(s.charAt(0) == s.charAt(1)){
                if(map.get(s) > 0){
                    unpaired--;
                    map.put(s, map.get(s)-1);
                    len += 4;
                }
                else{
                    map.put(s, map.get(s)+1);
                    unpaired++;
                }
            }
            else{
                String rev = Character.toString(s.charAt(1)) + Character.toString(s.charAt(0));
                if(map.containsKey(rev) && map.get(rev) > 0){
                    len += 4;
                    map.put(rev, map.get(rev)-1);
                }
                else{
                    map.put(s, map.get(s)+1);
                }
            }
        }
        if(unpaired > 0){
            len += 2;
        }
        return len;
    }
}