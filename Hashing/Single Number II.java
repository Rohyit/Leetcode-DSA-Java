// Problem: Single Number II
// Link: https://leetcode.com/problems/single-number-ii/description/
// Approach: Hashing

package Hashing;
import java.util.*;

class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(int num : map.keySet()){
            if(map.get(num) == 1){
                return num;
            }
        }
        return -1;
    }
}