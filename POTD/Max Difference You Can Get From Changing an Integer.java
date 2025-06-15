// Problem: Max Difference You Can Get From Changing an Integer
// Link: https://leetcode.com/problems/max-difference-you-can-get-from-changing-an-integer/description/
// Date : 15-June-2025

package POTD;
import java.util.*;

class Solution {
    public int maxDiff(int num) {
        String smax = Integer.toString(num);
        for(int i=0; i<smax.length(); i++){
            char c = smax.charAt(i);
            if(c != '9'){
                smax = smax.replace(c, '9');
                break;
            }
        }
        int a = Integer.parseInt(smax);

        if(num < 10){
            return a-1;
        }

        String smin = Integer.toString(num);
        Set<Character> set = new HashSet<>();

        for(int i=0; i<smin.length(); i++){
            set.add(smin.charAt(i));
        }

        for(int i=0; i<smin.length(); i++){
            char c = smin.charAt(i);
            if(i == 0 && c != '1'){
                smin = smin.replace(c, '1');
                break;
            }
            else if(i != 0 && set.size() != 1 && c != '0' && c != smin.charAt(0)){
                smin = smin.replace(c, '0');
                break;
            }
        }
        int b = Integer.parseInt(smin);
        
        return a-b;
    }
}