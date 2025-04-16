// Problem: Maximum Number of Vowels in a Substring of Given Length
// Link: https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/
// Approach: Sliding Window

class Solution {
    public int maxVowels(String s, int k) {
        int maxVowels = 0, currVowels=0;
        String str = "aeiou";
        for(int i=0; i<k; i++){
            if(str.indexOf(s.charAt(i)) != -1){
                currVowels++;
            }
        }
        maxVowels = Math.max(maxVowels, currVowels);

        for(int i=k; i<s.length(); i++){
            if(str.indexOf(s.charAt(i-k)) != -1){
                currVowels--;
            }
            if(str.indexOf(s.charAt(i)) != -1){
                currVowels++;
            }
            maxVowels = Math.max(maxVowels, currVowels);
        }
        return maxVowels;
    }
}