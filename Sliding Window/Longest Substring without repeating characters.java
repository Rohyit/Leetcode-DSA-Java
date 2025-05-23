// Problem: Longest Substring without repeating characters
// Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
// Approach: Sliding Window

import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int l=0, r=0, len=0;
        int n = s.length();

        while(r<n){
            if(map.containsKey(s.charAt(r))){
                l = Math.max(map.get(s.charAt(r)) + 1, l);
            }
            map.put(s.charAt(r), r);
            len = Math.max(len, r-l+1);
            r++;
        }
        return len;
    }
}