// Problem: Asteroid Collision
// Link: https://leetcode.com/problems/asteroid-collision/description/
// Approach: Stack

package Stack;
import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for(int num : asteroids){
            if(stack.isEmpty()){
                stack.push(num);
            }
            else if(stack.peek()>0 && num<0){
                boolean shouldAdd = true;
                while(!stack.isEmpty() && stack.peek()>0 && num<0){
                    if(Math.abs(stack.peek())<Math.abs(num)){
                    stack.pop();
                    }
                    else if(Math.abs(stack.peek())==Math.abs(num)){
                        stack.pop();
                        shouldAdd = false;
                        break;
                    }
                    else{
                        shouldAdd = false;
                        break;
                    }
                }
                if(shouldAdd){
                    stack.push(num);
                }
            }
            else{
                stack.push(num);
            }
        }
        int[] arr = new int[stack.size()];
        for(int i=arr.length-1; i>=0; i--){
            arr[i] = stack.pop();
        }

        return arr;
    }
}