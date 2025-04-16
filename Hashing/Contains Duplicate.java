
// Problem: Contains Duplicate
// Link: https://leetcode.com/problems/contains-duplicate/description/
// Approach: Hashing

package Hashing;
import java.util.*;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();

        for(int num : nums){
            if(set.contains(num)){
                return true;
            }
            set.add(num);
        }
        return false;
    }
}