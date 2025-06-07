// Problem: Lexicographically Minimum String After Removing Stars
// Link: https://leetcode.com/problems/lexicographically-minimum-string-after-removing-stars/description/
// Date : 07-June-2025

package POTD;
import java.util.*;

class Solution {
    public String clearStars(String s) {
        if(s.indexOf('*') == -1){
            return s;
        }
        char[] arr = s.toCharArray();
        List<Integer>[] pos = new ArrayList[26];
        for(int i=0; i<26; i++){
            pos[i] = new ArrayList<>();
        }
        PriorityQueue<Character> pq = new PriorityQueue<>();
        for(int i = 0; i<arr.length; i++){
            char c = arr[i];
            if(c == '*'){
                char minChar = pq.peek();
                List<Integer> list = pos[minChar - 'a'];
                int j = list.remove(list.size() - 1);
                arr[j] = '*';
                if(list.isEmpty()){
                    pq.poll();
                }
            }
            else{
                int ci = c - 'a';
                if(pos[ci].isEmpty()){
                    pq.add(c);
                }
                pos[ci].add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c : arr){
            if(c != '*'){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}