// Problem: Product of Array Except Self
// Link: https://leetcode.com/problems/product-of-array-except-self/description/

package Miscellaneous;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        
        int prod = 1;
        int cntZero = 0;
        for(int i=0; i<n; i++){
            prod *= nums[i];
            if(nums[i] == 0){
                cntZero++;
            }
        }
        if(prod != 0){
            for(int i=0; i<n; i++){
                arr[i] = prod/nums[i];
            }
            return arr;
        }
        else{
            if(cntZero > 1){
                return arr;
            }
            else{
                int product = 1;
                for(int i=0; i<n; i++){
                    if(nums[i] == 0){
                        continue;
                    }
                    product *= nums[i];
                }
                for(int i=0; i<n; i++){
                    if(nums[i] == 0){
                        arr[i] = product;
                    }
                }
                return arr;
            }
        }
    }
}