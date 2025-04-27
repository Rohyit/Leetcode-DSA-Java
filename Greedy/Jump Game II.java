// Problem: Jump Game II
// Link: https://leetcode.com/problems/jump-game-ii/
// Approach: Greedy 

package Greedy;

class Solution {
    public int jump(int[] nums) {
        int jumps = 0, farthest = 0, boundary = 0;

        for(int i=0; i<nums.length-1; i++){
            farthest = Math.max(farthest, i+nums[i]);

            if(i==boundary){
                jumps++;
                boundary = farthest;
            }
        }
        return jumps;
    }
}