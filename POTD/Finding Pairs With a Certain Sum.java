// Problem: Finding Pairs With a Certain Sum
// Link: https://leetcode.com/problems/finding-pairs-with-a-certain-sum/description/
// Date : 06-July-2025

package POTD;
import java.util.*;

class FindSumPairs {
    int[] arr1, arr2;
    int n1, n2;
    Map<Integer, Integer> map = new HashMap<>();

    public FindSumPairs(int[] nums1, int[] nums2) {
        arr1 = nums1;
        arr2 = nums2;
        n1 = arr1.length;
        n2 = arr2.length;
        for(int i=0; i<n2; i++){
            map.put(arr2[i], map.getOrDefault(arr2[i], 0)+1);
        }
    }
    
    public void add(int index, int val) {
        map.put(arr2[index], map.get(arr2[index])-1);
        arr2[index] += val;
        map.put(arr2[index], map.getOrDefault(arr2[index], 0)+1);
    }
    
    public int count(int tot) {
        int cnt = 0;    
        for(int i=0; i<n1; i++){
            cnt += map.getOrDefault(tot - arr1[i], 0);
        }
        return cnt;
    }
}