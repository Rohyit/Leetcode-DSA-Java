// Problem: Minimize the Maximum Difference of Pairs
// Link: https://leetcode.com/problems/minimize-the-maximum-difference-of-pairs/description/
// Date : 13-June-2025

package POTD;
import java.util.*;

class Solution {
    public int minimizeMax(int[] nums, int p) {
        int n = nums.length;
        Arrays.sort(nums);
        int low = 0;
        int high = nums[n-1] - nums[0];

        while(low < high){
            int mid = low + (high - low)/2;
            if(canFormPairs(nums, p, mid)){
                high = mid;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }
    public boolean canFormPairs(int[] nums, int p, int maxDiff){
        int cnt = 0;
        int i = 0;
        while(i < nums.length-1){
            if(nums[i+1] - nums[i] <= maxDiff){
                cnt++;
                i += 2;
            }
            else{
                i++;
            }
        }
        return cnt >= p;
    }
}
