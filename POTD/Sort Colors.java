// Problem: Sort Colors
// Link: https://leetcode.com/problems/sort-colors/description/
// Date : 17-May-2025

// T.C. : O(n)
// S.C. : O(1)

package POTD;

class Solution {
    public void sortColors(int[] nums) {
        int red=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==0){
                int temp = nums[red];
                nums[red] = nums[i];
                nums[i] = temp;
                red++;
            }
        }
        int white = red;
        for(int i=white; i<nums.length; i++){
            if(nums[i]==1){
                int temp = nums[white];
                nums[white] = nums[i];
                nums[i] = temp;
                white++;
            }
        }
    }
}