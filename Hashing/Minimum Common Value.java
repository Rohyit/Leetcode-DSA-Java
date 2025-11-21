// Problem: Minimum Common Value
// Link: https://leetcode.com/problems/minimum-common-value/description/
// Approach: Hashing

package Hashing;
import java.util.*;

class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<nums2.length; i++){
            set.add(nums2[i]);
        }
        for(int i=0; i<nums1.length; i++){
            if(set.contains(nums1[i])){
                return nums1[i];
            }
        }
        return -1;
    }
}