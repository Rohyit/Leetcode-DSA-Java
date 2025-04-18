// Problem: Palindrome Partitioning
// Link: https://leetcode.com/problems/palindrome-partitioning/
// Approach: Using Backtracking

package Backtracking;
import java.util.*;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        List<String> ds = new ArrayList<>();
        partitioning(0, s,ds, list);
        return list;
    }
    public void partitioning(int ind, String s, List<String> ds, List<List<String>> list){
        if(ind==s.length()){
            list.add(new ArrayList<>(ds));
            return;
        }
        for(int i=ind; i<s.length(); ++i){
            if(isPalindrome(s, ind, i)){
                ds.add(s.substring(ind, i+1));
                partitioning(i+1, s, ds, list);
                ds.remove(ds.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s, int start, int end){
        while(start<=end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}