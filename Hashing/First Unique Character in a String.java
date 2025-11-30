// Problem: First Unique Character in a String
// Link: https://leetcode.com/problems/first-unique-character-in-a-string/description/
// Approach: Hashing

import java.util.*;

class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for(int i=0; i<s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for(char c : map.keySet()){
            if(map.get(c) == 1){
                return s.indexOf(c);
            }
        }
        return -1;
    }
}