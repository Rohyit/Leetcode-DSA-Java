
// Problem: Find All Numbers Disappeared in an Array
// Link: https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
// Approach: Hashing


package Hashing;
import java.util.*;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for(int i=0; i<n; i++){
            set.add(nums[i]);
        }
        for(int i=1; i<=n; i++){
            if(!set.contains(i)){
                list.add(i);
            }
        }
        return list;
    }
}