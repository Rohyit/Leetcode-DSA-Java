// Problem: Longest Repeating Character Replacement
// Link: https://leetcode.com/problems/longest-repeating-character-replacement/description/
// Approach: Sliding Window

class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, r = 0, maxLen = 0, maxFreq = 0;
        int n = s.length();
        int[] hash = new int[26];

        while(r<n){
            hash[s.charAt(r) -'A']++;
            maxFreq = Math.max(maxFreq, hash[s.charAt(r)-'A']);

            if((r-l+1) - maxFreq > k){
                hash[s.charAt(l) - 'A']--;
                l++;
            }
            
            maxLen = Math.max(maxLen, (r-l+1));
            r++;
        }
        return maxLen;
    }
}