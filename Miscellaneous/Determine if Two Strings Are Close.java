// Problem: Determine if Two Strings Are Close
// Link: https://leetcode.com/problems/determine-if-two-strings-are-close/

package Miscellaneous;
import java.util.*;

class Solution {
    public boolean closeStrings(String word1, String word2) {
        int[] vis1 = new int[26];
        int[] vis2 = new int[26];

        for(char c : word1.toCharArray()){
            vis1[c - 'a']++;
        }
        for(char c : word2.toCharArray()){
            vis2[c - 'a']++;
        }    
        for(int i = 0; i < 26; i++){
            if((vis1[i] == 0 && vis2[i] != 0) || (vis1[i] != 0 && vis2[i] == 0)){
                return false;
            }
        }
        Arrays.sort(vis1);
        Arrays.sort(vis2);

        for(int i = 0; i < 26; i++){
            if(vis1[i] != vis2[i]){
                return false;
            }
        }
        return true;
    }
}