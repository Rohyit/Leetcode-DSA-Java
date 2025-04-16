
// Problem: Find the Difference of Two Arrays
// Link: https://leetcode.com/problems/find-the-difference-of-two-arrays/description/
// Approach: Hashing

package Hashing;
import java.util.*;

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for(int num1 : nums1){
            set1.add(num1);
        }
        for(int num2 : nums2){
            set2.add(num2);
        }

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        
        for(int num1 : set1){
            if(!set2.contains(num1)){
                list1.add(num1);
            }
        }
        for(int num2 : set2){
            if(!set1.contains(num2)){
                list2.add(num2);
            }
        }
        return Arrays.asList(list1, list2);
    }
}