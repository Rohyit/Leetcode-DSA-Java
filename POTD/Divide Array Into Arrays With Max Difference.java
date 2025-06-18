// Problem: Divide Array Into Arrays With Max Difference
// Link: https://leetcode.com/problems/divide-array-into-arrays-with-max-difference/description/
// Date : 18-June-2025

package POTD;
import java.util.*;

class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        int m = n/3;
        int[][] ans = new int[m][3];
        Arrays.sort(nums);
        int l = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<3; j++){
                ans[i][j] = nums[l];
                l++;
            }
        }
        for(int i=0; i<m; i++){
            if(ans[i][2] - ans[i][0] > k){
                return new int[0][0];
            }
        }
        return ans;
    }
}
