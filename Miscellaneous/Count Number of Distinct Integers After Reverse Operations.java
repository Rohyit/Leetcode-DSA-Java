// Problem: Count Number of Distinct Integers After Reverse Operations
// Link: https://leetcode.com/problems/count-number-of-distinct-integers-after-reverse-operations/description/

package Miscellaneous;
import java.util.*;

class Solution {
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
            int num = nums[i];
            String s = "";
            while(num >= 1){
                int digit = num % 10;
                s = s + digit;
                num = num / 10;
            }
            int reverse = Integer.parseInt(s);
            set.add(reverse);
        }
        return set.size();
    }
}