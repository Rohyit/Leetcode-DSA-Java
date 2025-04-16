
// Problem: Unique Number of Occurrences
// Link: https://leetcode.com/problems/unique-number-of-occurrences/description/
// Approach: Hashing

package Hashing;
import java.util.*;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num : arr){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        Set<Integer> set = new HashSet<Integer>();
        for(int x : map.values()){
            set.add(x);
        }
        return map.size()==set.size();
    }
}