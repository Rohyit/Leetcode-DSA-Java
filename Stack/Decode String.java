// Problem: Decode String
// Link: https://leetcode.com/problems/decode-string/
// Approach: Stack

package Stack;
import java.util.*;

class Solution {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        int currNum = 0;
        StringBuilder currStr = new StringBuilder();

        for(char ch : s.toCharArray()){
            if(Character.isDigit(ch)){
                currNum = 10 * currNum + (ch - '0');
            }
            else if(ch == '['){
                strStack.push(currStr);
                numStack.push(currNum);
                currStr = new StringBuilder();
                currNum = 0;
            }
            else if(ch == ']'){
                StringBuilder prevStr = strStack.pop();
                int repeat = numStack.pop();
                for(int i=0; i<repeat; i++){
                    prevStr.append(currStr);
                }
                currStr = prevStr;
            }
            else{
                currStr.append(ch);
            }
        }
        return currStr.toString(); 
    }
}