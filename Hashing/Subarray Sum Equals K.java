
// Problem: Subarray Sum Equals K
// Link: https://leetcode.com/problems/subarray-sum-equals-k/description/
// Approach: Hashing

package Hashing;
import java.util.*;

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum=0, count=0;
        map.put(0,1);

        for(int num: nums){
            prefixSum+=num;

            if(map.containsKey(prefixSum-k)){
                count+= map.get(prefixSum-k);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0)+1);
        }
        return count;
    }
}