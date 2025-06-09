// Problem: Top K Frequent Elements
// Link: https://leetcode.com/problems/top-k-frequent-elements/description/
// Approach: Hashing

package Hashing;
import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        Map<Integer, Integer> sortedMap = new LinkedHashMap<>();
        int cnt = 0;
        int[] arr = new int[k];
        for(Map.Entry<Integer, Integer> entry : list){
            sortedMap.put(entry.getKey(), entry.getValue());
            arr[cnt] = entry.getKey();
            cnt++;
            if(cnt == k){
                break;
            }
        }
        return arr;
    }
}