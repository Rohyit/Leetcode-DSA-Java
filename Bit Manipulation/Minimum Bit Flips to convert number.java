// Problem: Minimum Bit Flips to convert number
// Link: https://leetcode.com/problems/minimum-bit-flips-to-convert-number/description/
// Approach: Bit Manipulation

class Solution {
    public int minBitFlips(int start, int goal) {
        int ans = start ^ goal;
        int count = 0;
        while(ans != 0){
            count += ans & 1;
            ans = ans >> 1;
        }
        return count;
    }
}