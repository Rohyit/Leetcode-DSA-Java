// Problem: Number of Good Pairs
// Link: https://leetcode.com/problems/number-of-good-pairs/
// Approach: Hashing

package Hashing;
import java.util.*;

class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        int pairs = 0;
        for(int val : map.values()){
            pairs += val*(val-1)/2; // If a number appears n times, then n*(n-1)/2 good pairs.
        }
        return pairs;
    }
}