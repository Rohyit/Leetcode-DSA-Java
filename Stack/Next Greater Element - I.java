// Problem: Next Greater Element - I
// Link: https://leetcode.com/problems/next-greater-element-i/description/
// Approach: Stack

package Stack;
import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for(int i = nums2.length-1; i>=0; i--){
            if(stack.isEmpty()){
                map.put(nums2[i], -1);
            }
            else if(!stack.isEmpty() && stack.peek()>nums2[i]){
                map.put(nums2[i], stack.peek());
            }
            else if(!stack.isEmpty() && stack.peek()<=nums2[i]){
                while(!stack.isEmpty() && stack.peek()<=nums2[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    map.put(nums2[i], -1);
                }
                else{
                    map.put(nums2[i], stack.peek());
                }
            }
            stack.push(nums2[i]);
        }

        int[] arr = new int[nums1.length];
        for(int i=0; i<arr.length; i++){
            arr[i] = map.get(nums1[i]);
        }
        return arr; 
    }
}