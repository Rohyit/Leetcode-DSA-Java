// Problem: Maximum Difference by Remapping a Digit
// Link: https://leetcode.com/problems/maximum-difference-by-remapping-a-digit/description/
// Date : 14-June-2025

package POTD;

class Solution {
    public int minMaxDifference(int num) {
        String smax = Integer.toString(num);
        String smin = Integer.toString(num);
        for(int i=0; i<smax.length(); i++){
            char c = smax.charAt(i);
            if(c != '9'){
                smax = smax.replace(c, '9');
                break;
            }
        }
        int max = Integer.parseInt(smax);
        for(int i=0; i<smin.length(); i++){
            char c = smin.charAt(i);
            if(c != '0'){
                smin = smin.replace(c, '0');
                break;
            }
        }
        int min = Integer.parseInt(smin);
        return max-min;
    }
}