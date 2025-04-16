// Problem: Valid Parentheses
// Link: https://leetcode.com/problems/valid-palindrome/description/
// Approach: Stack

package Stack;
import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch=='(' || ch=='[' || ch=='{'){
                stack.push(ch);
            }
            else{
                if(stack.isEmpty()){
                    return false;
                }
                char c = stack.peek();
                stack.pop();

                if(s.charAt(i)==')' && c=='(' || s.charAt(i)=='}' && c=='{' || s.charAt(i)==']' && c=='['){
                    continue;
                }
                else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}