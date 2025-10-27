// Problem: Vowels of all Substrings
// Link: https://leetcode.com/problems/vowels-of-all-substrings/description/

package Miscellaneous;
import java.util.*;

class Solution {
    public long countVowels(String word) {
        long count = 0;
        long n = word.length();
        for(int i= 0; i<n; i++){
            char c = word.charAt(i);
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                count += (long)(i+1)*(n-i);
            }
        }
        return count;
    }
}