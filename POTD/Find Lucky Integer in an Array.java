// Problem: Find Lucky Integer in an Array
// Link: https://leetcode.com/problems/find-lucky-integer-in-an-array/description/
// Date : 05-July-2025

package POTD;
import java.util.*;

class Solution {
    public int findLucky(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        int ans = Integer.MIN_VALUE;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getKey() == entry.getValue() && entry.getKey() > ans){
                ans = entry.getKey();
            }
        }
        if(ans == Integer.MIN_VALUE){
            return -1;
        }
        return ans;
    }
}