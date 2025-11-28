// Problem: Smallest Missing Multiple of K
// Link: https://leetcode.com/problems/smallest-missing-multiple-of-k/description/
// Approach: Hashing

package Hashing;
import java.util.*;

class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int n = 1;
        while(set.contains(k*n)){
            n++;
        }
        return k*n;
    }
}