// Problem: Roman to Integer
// Link: https://leetcode.com/problems/roman-to-integer/

// T.C. : O(n)
// S.C. : O(1)

package Miscellaneous;
import java.util.*;

class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int val = 0;
        for(int i=0; i<s.length(); i++){
            int curr = map.get(s.charAt(i));

            if(i+1 < s.length() && curr<map.get(s.charAt(i+1))){
                val = val - curr;
            }
            else{
                val = val + curr;
            }
        }
        return val;
    }
}