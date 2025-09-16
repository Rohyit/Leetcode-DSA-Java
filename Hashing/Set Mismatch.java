// Problem: Set Mismatch
// Link: https://leetcode.com/problems/set-mismatch/
// Approach: Hashing

// T.C. : O(n)
// S.C. : O(n)

package Hashing;
import java.util.*;

class Solution {
    public int[] findErrorNums(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        int duplicate = -1;
        for(int i=0; i<n; i++){
            if(set.contains(nums[i])){
                duplicate = nums[i];
            }
            set.add(nums[i]);
        }
    
        int missing = -1;

        for(int i=1; i<=n; i++){
            if(!set.contains(i)){
                missing = i;
                break;
            }
        }
        return new int[]{duplicate, missing};
    }
}