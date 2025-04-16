// Problem: Find the Duplicate Number
// Link: https://leetcode.com/problems/find-the-duplicate-number/description/
// Approach: Hashing
package Hashing;
import java.util.*;

class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int num : nums){
            if(set.contains(num)){
                return num;
            }
            set.add(num);
        }
        return -1;
    }
}