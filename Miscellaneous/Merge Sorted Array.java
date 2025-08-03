// Problem: Merge Sorted Array
// Link: https://leetcode.com/problems/merge-sorted-array/description/

package Miscellaneous;
import java.util.*;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int ind = m;
        for(int i=0; i<n; i++){
            nums1[ind] = nums2[i];
            ind++;
        }
        Arrays.sort(nums1);
    }
}