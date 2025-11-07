// Problem: Longest Palindrome
// Link: https://leetcode.com/problems/longest-palindrome/

package Miscellaneous;

class Solution {
    public int longestPalindrome(String s) {
        int n = s.length();
        int odd = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i =0; i<n; i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
            if(map.get(c) % 2 == 1){
                odd++;
            }
            else{
                odd--;
            }
        }
        if(odd > 1){
            return n-odd+1;
        }
        return n;

    }
}