// Problem: Maximize Y‑Sum by Picking a Triplet of Distinct X‑Values
// Link: https://leetcode.com/problems/maximize-ysum-by-picking-a-triplet-of-distinct-xvalues/description/
// Contest : BiWeekly-158

package Contests;
import java.util.*;

class Solution {
    public int maxSumDistinctTriplet(int[] x, int[] y) {
        int n = x.length;
        if(n < 3){
            return -1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< n; i++){
            map.put(x[i], Math.max(map.getOrDefault(x[i], Integer.MIN_VALUE), y[i]));
        }
        if(map.size() < 3){
            return -1;
        }
        List<Integer> list = new ArrayList<>(map.values());
        list.sort(Collections.reverseOrder());
        
        return list.get(0) + list.get(1) + list.get(2);
    }
}