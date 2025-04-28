// Problem: Valid Parenthesis String
// Link: https://leetcode.com/problems/valid-parenthesis-string/description/
// Approach: Greedy 

package Greedy;

class Solution {
    public boolean checkValidString(String s) {

        // Range of Min & Max 
        int min = 0;
        int max = 0;
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                min++;
                max++;
            }
            else if(s.charAt(i)==')'){
                min--;
                max--;
            }
            else{
                min--;
                max++;
            }

            if(min<0){
                min=0;
            }
            if(max<0){
                return false;
            }
        }
        return min==0;
    }
}