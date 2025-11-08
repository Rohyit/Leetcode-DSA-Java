// Problem: Longest Common Prefix
// Link: https://leetcode.com/problems/longest-common-prefix/

package Miscellaneous;
import java.util.*;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        int n = strs.length;
        String s1 = strs[0];
        String s2 = strs[n-1];

        int ind = 0;

        while(ind<s1.length() && ind<s2.length()){
            if(s1.charAt(ind) == s2.charAt(ind)){
                ind++;
            }
            else{
                break;
            }
        }
        return s1.substring(0,ind);
    }
}
