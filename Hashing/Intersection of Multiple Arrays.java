// Problem: Intersection of Multiple Arrays
// Link: https://leetcode.com/problems/intersection-of-multiple-arrays/description/
// Approach: Hashing

package Hashing;
import java.util.*;

class Solution {
    public List<Integer> intersection(int[][] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums[0]){
            set.add(num);
        }
        for(int i=1; i<nums.length; i++){
            Set<Integer> temp = new HashSet<>();
            for(int j=0; j<nums[i].length; j++){
                if(set.contains(nums[i][j])){
                    temp.add(nums[i][j]);
                }
            }
            set = temp;
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        return list;
    }
}