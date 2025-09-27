
// Problem: Contains Duplicate II
// Link: https://leetcode.com/problems/contains-duplicate-ii/description/
// Approach: Hashing

// T.C. : O(n)
// S.C. : O(n)

package Hashing;
import java.util.*;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i]) && (i-map.get(nums[i])<=k)){
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}