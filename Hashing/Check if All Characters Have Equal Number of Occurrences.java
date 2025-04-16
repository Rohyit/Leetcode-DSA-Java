
// Problem: Check if All Characters Have Equal Number of Occurrences
// Link: https://leetcode.com/problems/check-if-all-characters-have-equal-number-of-occurrences/description/
// Approach: Hashing

package Hashing;
import java.util.*;

class Solution {
    public boolean areOccurrencesEqual(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        Set<Integer> set = new HashSet<Integer>(map.values());
        return set.size()==1;
    }
}