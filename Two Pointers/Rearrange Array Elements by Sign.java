// Problem: Rearrange Array Elements by Sign
// Link: https://leetcode.com/problems/rearrange-array-elements-by-sign/description/
// Approach: Two pointer

import java.util.*;

class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] arr = new int[nums.length];
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        
        for(int num : nums){
            if(num>0){
                list1.add(num);
            }
            else{
                list2.add(num);
            }
        }
        int pos=0, neg=1;
        for(int i=0; i<list1.size(); i++){
            arr[pos] = list1.get(i);
            arr[neg] = list2.get(i);
            pos+=2;
            neg+=2;
        }
        return arr;
    }
}