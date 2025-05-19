// Problem : Type of Triangle
// Link: https://leetcode.com/problems/type-of-triangle/
// Date : 19-May-2025

package POTD;
import java.util.*;

class Solution {
    public String triangleType(int[] nums) {
        if(nums[0] + nums[1] <= nums[2] || nums[1] + nums[2] <= nums[0] || nums[2] + nums[0] <= nums[1]){
            return "none";
        }
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<3; i++){
            set.add(nums[i]);
        }
        if(set.size() == 3){
            return "scalene";
        }
        else if(set.size() == 2){
            return "isosceles";
        }
        else{
            return "equilateral";
        }
    }
}