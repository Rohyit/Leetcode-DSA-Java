
// Problem: Majority Element
// Link: https://leetcode.com/problems/majority-element/description//
// Approach: Hashing

// T.C. : O(n)
// S.C. : O(n)

package Hashing;
import java.util.*;

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);

            if(map.get(num)>nums.length/2){
                return num;
            }
        }
        return -1;
    }
}