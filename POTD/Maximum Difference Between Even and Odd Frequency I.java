// Problem: Maximum Difference Between Even and Odd Frequency I
// Link: https://leetcode.com/problems/maximum-difference-between-even-and-odd-frequency-i/description/
// Date : 10-June-2025

package POTD;
import java.util.*;

class Solution {
    public int maxDifference(String s) {
        int[] arr = new int[26];
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            arr[c - 'a']++;
        }
        Arrays.sort(arr);

        int oddMax = Integer.MIN_VALUE;
        int evenMin = Integer.MAX_VALUE;
        
        for(int i=25; i>=0; i--){
            if(arr[i] != 0 && arr[i] % 2 != 0){
                oddMax = arr[i];
                break;
            }
        }
        for(int i=0; i<26; i++){
            if(arr[i] != 0 && arr[i] % 2 == 0){
                evenMin = arr[i];
                break;
            }
        }
        return oddMax - evenMin;
    }
}