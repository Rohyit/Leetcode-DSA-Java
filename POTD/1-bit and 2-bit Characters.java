// Problem: 1-bit and 2-bit Characters
// Link: https://leetcode.com/problems/1-bit-and-2-bit-characters/description/
// Date : 18-Nov-2025

package POTD;

class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
    
        for(int i=0; i<n; i++){
            if(bits[i] == 1){
                if(bits[i] == 1 && i == n-2){
                    return false;
                }
                i++;
            }
        }
        return true;
    }
}