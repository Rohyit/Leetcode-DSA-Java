// Problem: How Many Numbers Are Smaller Than the Current Number
// Link: https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/description/

package Miscellaneous;

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];

        for(int i = 0; i<n; i++){
            int val = 0;
            for(int num : nums){
                if(num < nums[i]){
                    val++;
                }
            }
            arr[i] = val;
        }
        return arr;
    }
}
