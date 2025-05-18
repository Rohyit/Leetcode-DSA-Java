// Problem: Minimum Deletions for At Most K Distinct Characters
// Link: https://leetcode.com/problems/minimum-deletions-for-at-most-k-distinct-characters/description/
// Contest : Weekly-449

package Contests;
import java.util.*;

class Solution {
    public int minDeletion(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        if(map.size() <= k){
            return 0;
        }
        int toDel = map.size() - k;
        int min = 0;

        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list);
        
        for(int i=0; i<toDel; i++){
            min += list.get(i);
        }
        return min;
    }
}