// Problem: Find Subsequence of Length K With the Largest Sum
// Link: https://leetcode.com/problems/find-subsequence-of-length-k-with-the-largest-sum/description/
// Date : 28-June-2025

package POTD;
import java.util.*;

class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        int[][] index = new int[n][2];
        for(int i=0; i<n; i++){
            index[i] = new int[]{nums[i], i};
        }
        Arrays.sort(index, (a,b) -> b[0] - a[0]);
        Arrays.sort(index, 0, k, (a,b) -> a[1] - b[1]);
        int[] arr = new int[k];
        for(int i=0; i<k; i++){
            arr[i] = index[i][0];
        }
        return arr;
    }
}