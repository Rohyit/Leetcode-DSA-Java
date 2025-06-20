// Problem: Maximum Manhattan Distance After K Changes
// Link: https://leetcode.com/problems/maximum-manhattan-distance-after-k-changes/description/
// Date : 20-June-2025

package POTD;

class Solution {
    public int maxDistance(String s, int k) {
        int len = s.length();
        int north = 0, south = 0, east = 0, west = 0;
        int maxDist = 0;

        for(int i = 0; i<len; i++){
            char c = s.charAt(i);
            if(c == 'N'){
                north++;
            }
            else if(c == 'S'){
                south++;
            }
            else if(c == 'E'){
                east++;
            }
            else if(c == 'W'){
                west++;
            }
            
            int base = Math.abs(north - south) + Math.abs(east - west);
            int extra = Math.min(2*k, i+1-base);
            int total = base + extra;

            maxDist = Math.max(total, maxDist);
        }

        return maxDist;
    }
}