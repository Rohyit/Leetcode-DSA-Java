// Problem: Merge Sorted Array
// Link: https://leetcode.com/problems/merge-sorted-array/description/

// T.C. : O(m+n)
// S.C. : O(1)

package Miscellaneous;
import java.util.*;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    /*
        // BRUTE FORCE - O(nlogn)

        int ind = m;
        for(int i=0; i<n; i++){
            nums1[ind] = nums2[i];
            ind++;
        }
        Arrays.sort(nums1);
    } */

        // OPTIMIZED

        int i = m-1, j = n-1, k = m+n-1;
        while(j>=0){
            if(i>= 0 && nums1[i] >= nums2[j]){
                nums1[k] = nums1[i];
                i--;
            }
            else{
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
        
    }
}
