// Problem: Minimum Number of Operations to Move All Balls to Each Box
// Link: https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/

package Miscellaneous;

class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            int cnt = 0;
            for(int j=0; j<n; j++){
                if(boxes.charAt(j) != '0'){
                    cnt += Math.abs(i-j);
                }
            }
            arr[i] = cnt;
        }
        return arr; 
    }
}