// Problem : Zero Array Transformation I
// Link: https://leetcode.com/problems/zero-array-transformation-i/description/
// Date : 20-May-2025

package POTD;

class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1];

        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];

            diff[l] += 1;
            if (r + 1 < n) {
                diff[r + 1] -= 1;
            }
        }

        int cnt = 0;
        for(int i=0; i<n; i++){
            cnt += diff[i];
            if(nums[i] > cnt){
                return false;
            }
        }
        return true;
    }
}
