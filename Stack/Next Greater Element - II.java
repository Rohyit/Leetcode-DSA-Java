// Problem: Next Greater Element - II
// Link: https://leetcode.com/problems/next-greater-element-ii/description/
// Approach: Stack

package Stack;
import java.util.*;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] nge = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=2*nums.length-1; i>=0; i--){
            int index = i%nums.length;
            while(!stack.isEmpty() && stack.peek()<=nums[index]){
                stack.pop();
            }
            if(stack.isEmpty()){
                nge[index]= -1;
            }
            else{
                nge[index] = stack.peek();
            }
            stack.push(nums[index]);
        }
        return nge;
    }
}