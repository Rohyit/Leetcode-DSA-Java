
// Problem: Valid Anagram
// Link: https://leetcode.com/problems/valid-anagram/description/
// Approach: Hashing

package Hashing;
import java.util.*;

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }

        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        for(char c : t.toCharArray()){
            if(!map.containsKey(c)){
                return false;
            }
            map.put(c, map.get(c)-1);
            if(map.get(c)==0){
                map.remove(c);
            }
        }
        return map.isEmpty();
    }
}