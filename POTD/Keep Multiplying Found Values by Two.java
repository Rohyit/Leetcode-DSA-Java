// Problem: Keep Multiplying Found Values by Two
// Link: https://leetcode.com/problems/1-bit-and-2-bit-characters/description/
// Date : 19-Nov-2025

package POTD;

class Solution {
    public int findFinalValue(int[] nums, int original) {
        int val = original;
        while(isFound(nums, val)){
            val = val *= 2;
        }
        return val;
    }
    public boolean isFound(int[] nums, int value){
        int val = value;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == val){
                val *= 2;
                return true;
            }
        }
        return false; 
    /*
        int val = original;
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        while(set.contains(val)){
            val *= 2;
        }
        return val; */
    }

}