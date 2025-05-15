// Problem: Longest Unequal Adjacent Groups Subsequence I
// Link: https://leetcode.com/problems/longest-unequal-adjacent-groups-subsequence-i/
// Date : 15-May-2025

package POTD;
import java.util.*;

class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> list = new ArrayList<>();
        list.add(words[0]);
        int l = 0;
        for(int r=1; r<words.length; r++){
            if(groups[l] != groups[r]){
                list.add(words[r]);
                l=r;
            }
        }
        return list;
    }
}