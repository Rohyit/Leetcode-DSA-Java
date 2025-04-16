// Problem: 3Sum
// Link: https://leetcode.com/problems/3sum/
// Approach: Two pointer

import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> al = new ArrayList<>();  
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++){
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int j=i+1, k=nums.length-1;

            while(j<k){
                if(nums[i]+nums[j]+nums[k]==0){
                    al.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while(j<k && nums[j]==nums[j+1]){
                        j++;
                    }
                    while(j<k && nums[k]==nums[k-1]){
                        k--;
                    }
                    j++;
                    k--;
                }


                else if(nums[i]+nums[j]+nums[k]<0){
                    j++;
                }
                else if(nums[i]+nums[j]+nums[k]>0){
                    k--;
                }
            }  
        }
        return al;
    }
}
