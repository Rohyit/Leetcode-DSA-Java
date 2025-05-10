// Problem: Find Most Frequent Vowel and Consonant
// Link: https://leetcode.com/contest/biweekly-contest-156/problems/find-most-frequent-vowel-and-consonant/
// Contest : BiWeekly-156

package Contests;
import java.util.*;

class Solution {
    public int maxFreqSum(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        int Vfreq = 0;
        int Cfreq = 0;

        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            if(entry.getKey() == 'a' || entry.getKey() == 'e' || entry.getKey() == 'i' || entry.getKey() == 'o' || entry.getKey() == 'u'){
                Vfreq = Math.max(Vfreq, entry.getValue());
            }
        }
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            if(entry.getKey() != 'a' && entry.getKey() != 'e' && entry.getKey() != 'i' && entry.getKey() != 'o' && entry.getKey() != 'u'){
                Cfreq = Math.max(Cfreq, entry.getValue());
            }
        }
        return Vfreq+Cfreq;
    }
}