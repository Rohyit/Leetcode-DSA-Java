// Problem: Three Consecutive Odds
// Link: https://leetcode.com/problems/three-consecutive-odds/
// Date : 11-May-2025

package POTD;

class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        if(arr.length<3){
            return false;
        }
        int count = 0;
        for(int i=0; i<3; i++){
            if(arr[i] % 2 != 0){
                count++;
            }
        }
        if(count == 3){
            return true;
        }
        for(int i=3; i<arr.length; i++){
            if(arr[i] % 2 != 0){
                count++;
            }
            if(arr[i-3] % 2 != 0){
                count--;
            }
            if(count==3){
                return true;
            }
        }
        return false;
    }
}