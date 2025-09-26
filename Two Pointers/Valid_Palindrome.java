// Problem: Valid Palindrome
// Link: https://leetcode.com/problems/valid-palindrome/description/
// Approach: Two pointer

// BRUTE FORCE : T.C. : O(n) S.C. : O(n)
    /*
        Clean the given string. Take a new string and add the reversed clean aplhanumeric characters in this string and compare both.
    */


// Optimized
    // T.C. : O(n)
    // S.C. : O(1)

    class Solution {
    public boolean isPalindrome(String s) {
        int i=0, j=s.length()-1;
        while(i<j){
            while(i<j && !Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }
            while(i<j && !Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}