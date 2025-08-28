// Problem: Find the Difference
// Link: https://leetcode.com/problems/find-the-difference/

// T.C. : O(n)
// S.C> : O(1)

package Miscellaneous;
import java.util.*;

class Solution {
    public char findTheDifference(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        
        for(char c : s.toCharArray()){
            if(!map.containsKey(c)){
                return c;
            }
            map.put(c, map.get(c)-1);
            if(map.get(c)==0){
                map.remove(c);
            }
        }
        return map.keySet().iterator().next();
    }
}