// Problem: Letter Combinations of a Phone Number
// Link: https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
// Approach: Using Backtracking

// // T.C. : O(3^m * 4^n)

package Backtracking;
import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();

        if(digits.length() == 0 || digits == null){
            return list;
        }

        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        backtrack(digits, 0, new StringBuilder(), list, map);
        return list;
    }
    public void backtrack(String digits, int idx, StringBuilder ds, List<String> list, Map<Character, String> map){
        if(idx == digits.length()){
            list.add(ds.toString());
            return;
        }

        String letters = map.get(digits.charAt(idx));
        for(char c : letters.toCharArray()){
            ds.append(c);
            backtrack(digits, idx+1, ds, list, map);
            ds.deleteCharAt(ds.length()-1);
        }
    }
}