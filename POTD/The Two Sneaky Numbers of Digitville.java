// Link: https://leetcode.com/problems/the-two-sneaky-numbers-of-digitville/description/
// Date : 31-October-2025

// T.C. : O(N)
// S.C. : O(N)

package POTD;
import java.util.*;

class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int n = nums.length;
        int[] arr = new int[2];
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(set.contains(nums[i])){
                list.add(nums[i]);
            }
            set.add(nums[i]);
        }
        int i = 0;
        for(int num : list){
            arr[i] = num;
            i++;
        }
        return arr;
    }
}