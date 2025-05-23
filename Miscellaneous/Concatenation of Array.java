// Problem: Concatenation of Array
// Link: https://leetcode.com/problems/concatenation-of-array/description/

package Miscellaneous;

class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int ans[] = new int[2*n];
        for(int i=0; i<2*n; i++){
            if(i>=n){
                ans[i] = ans[i-n];
            }
            else{
                ans[i] = nums[i];
            }
        }
        return ans;
    }
}