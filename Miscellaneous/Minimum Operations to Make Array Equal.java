// Problem: Minimum Operations to Make Array Equal
// Link: https://leetcode.com/problems/minimum-operations-to-make-array-equal/description/

package Miscellaneous;

class Solution {
    public int minOperations(int n) {
        int[] arr = new int[n];
        int sum = 0;
        for(int i=0; i<n; i++){
            arr[i] = 2*i + 1;
            sum += arr[i];
        }
        int target = sum/n;
        int op = 0;
        for(int i = 0; i< n; i++){
            if(arr[i] < target){
                op += target - arr[i];
            }
        }
        return op;
    }
}