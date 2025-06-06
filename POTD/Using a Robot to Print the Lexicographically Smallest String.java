// Problem: Using a Robot to Print the Lexicographically Smallest String
// Link: https://leetcode.com/problems/using-a-robot-to-print-the-lexicographically-smallest-string/description/
// Date : 06-June-2025

package POTD;
import java.util.*;

class Solution {
    public String robotWithString(String s) {
        Stack<Character> stack = new Stack<>();
        int[] freq = new int[26];

        for(char c : s.toCharArray()){
            freq[c - 'a']++;
        }

        StringBuilder t = new StringBuilder();
        for(char c : s.toCharArray()){
            stack.push(c);
            freq[c - 'a']--;

            while(!stack.isEmpty() && stack.peek() <= smallestChar(freq)){
                t.append(stack.pop());
            }
        }

        while(!stack.isEmpty()){
            t.append(stack.pop());
        }
        
        return t.toString();
    }
    
    private char smallestChar(int[] freq){
            for(int i = 0; i < 26; i++){
                if(freq[i] > 0){
                    return (char)('a' + i);
                }
            }
            return 'a';
        }
}