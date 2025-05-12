// Problem : Finding 3-Digit Even Numbers
// Link: https://leetcode.com/problems/finding-3-digit-even-numbers/description/
// Date : 12-May-2025

package POTD;
import java.util.*;

class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] freq = new int[10];
        for(int num : digits){
            freq[num]++;
        }
        List<Integer> list = new ArrayList<>();
        for(int i=100; i<999; i+= 2){
            int a = i/100, b=(i/10) % 10, c=i%10;
            int[] nums = new int[10];
            nums[a]++;
            nums[b]++;
            nums[c]++;
            boolean valid = true;
            for(int num=0; num<10; num++){
                if(nums[num] > freq[num]){
                    valid = false;
                    break;
                }
            }
            if(valid){
                list.add(i);
            } 
        }
        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}