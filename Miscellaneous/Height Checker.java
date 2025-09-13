// Problem: Height Checker
// Link: https://leetcode.com/problems/height-checker/description/

// T.C. : O(nlogn)
// S.C. : O(n)

package Miscellaneous;
import java.util.*;

class Solution { 
    public int heightChecker(int[] heights) {
        int[] original = new int[heights.length];
        for(int i=0; i<heights.length; i++){
            original[i] = heights[i];
        }
        Arrays.sort(heights); 
        int count = 0;
        for(int i=0; i<heights.length; i++){
            if(heights[i] != original[i]){
                count++;
            }
        }
        return count;
    }
}