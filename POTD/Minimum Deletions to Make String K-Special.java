// Problem: Minimum Deletions to Make String K-Special
// Link: https://leetcode.com/problems/minimum-deletions-to-make-string-k-special/description/
// Date : 21-June-2025

package POTD;

class Solution {
    public int minimumDeletions(String word, int k) {
        int minCount = Integer.MAX_VALUE;
        int[] freq = new int[26];
        for(char c : word.toCharArray()){
            freq[c - 'a']++;
        }

        for(int i=0; i<26; i++){
            if(freq[i] == 0){
                continue;
            }
            int minDel = 0;
            for(int j=0; j<26; j++){
                if(freq[i] > freq[j]){
                    minDel += freq[j];
                }
                else if(Math.abs(freq[j] - freq[i]) > k){
                    minDel += Math.abs(freq[j] - freq[i] - k);
                }
            }
            minCount = Math.min(minCount, minDel);
        }
        return minCount;
    }
}