// Problem: Find All Anagrams in a String
// Link: https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
// Approach: Sliding Window

import java.util.*;
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        
        if(p.length() > s.length()){
            return list;
        }

        Map<Character, Integer> map = new HashMap<>();
        for(char c : p.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        int counter = map.size();

        int l=0, r=0, n= s.length();

        while(r<n){
            char right = s.charAt(r);
            if(map.containsKey(right)){
                map.put(right, map.get(right)-1);
                if(map.get(right)==0){
                    counter--;
                }
            }
            r++;

            while(counter==0){
                char left = s.charAt(l);
                if(map.containsKey(left)){
                    map.put(left, map.get(left)+1);
                    if(map.get(left)>0){
                        counter++;
                    }
                }
                if(r-l == p.length()){
                    list.add(l);
                }
                l++;
            }
        }
        return list;
    }
}