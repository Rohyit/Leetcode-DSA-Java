// Problem: Isomorphic Strings
// Link: https://leetcode.com/problems/isomorphic-strings/description/

package Miscellaneous;
import java.util.*;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            if(!mapS.containsKey(s.charAt(i))){
                mapS.put(s.charAt(i), i);
            }
            if(!mapT.containsKey(t.charAt(i))){
                mapT.put(t.charAt(i), i);
            }
            if(!mapS.get(s.charAt(i)).equals(mapT.get(t.charAt(i)))){
                return false;
            }
        }
        return true;
    }
}