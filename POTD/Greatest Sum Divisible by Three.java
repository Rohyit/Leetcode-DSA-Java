// Problem: Greatest Sum Divisible by Three
// Link: https://leetcode.com/problems/greatest-sum-divisible-by-three/description/
// Date : 23-Nov-2025

package POTD;
import java.util.*;

class Solution {
    public int maxSumDivThree(int[] nums) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        int sum = 0;
        for(int num : nums){
            if(num % 3 == 1){
                list1.add(num);
            }
            else if(num % 3 == 2){
                list2.add(num);
            }
            sum += num;
        }
        Collections.sort(list1);
        Collections.sort(list2);
        if(sum % 3 == 0){
            return sum;
        }
        else if(sum % 3 == 1){
            int op1 = (list1.size() >= 1) ? sum - list1.get(0) : 0;
            int op2 = (list2.size() >= 2) ? sum - list2.get(0) - list2.get(1) : 0; 
            return Math.max(op1, op2);
        }
        else{
            int op1 = (list2.size() >= 1) ? sum - list2.get(0) : 0;
            int op2 = (list1.size() >= 2) ? sum - list1.get(0) - list1.get(1) : 0;
            return Math.max(op1, op2);
        }
    }
}