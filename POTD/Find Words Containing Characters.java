// Problem: Find Words Containing Character
// Link: https://leetcode.com/problems/find-words-containing-character/
// Date : 24-May-2025

package POTD;
import java.util.*;

class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> list = new ArrayList<>();

        /* Brute Force : O(n^2)
        
        for(int i=0; i<words.length; i++){
            for(char c : words[i].toCharArray()){
                if(c==x){
                    list.add(i);
                    break;
                }
            }
        }
        
        */

        // Optimized : O(n)

        for(int i=0; i<words.length; i++){
            if(words[i].indexOf(x) != -1){
                list.add(i);
            }
        }
        return list;
    }
}