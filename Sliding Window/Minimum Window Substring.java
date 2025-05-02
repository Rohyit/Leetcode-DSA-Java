// Problem: Minimum Window Substring
// Link: https://leetcode.com/problems/minimum-window-substring/description/
// Approach: Sliding Window

class Solution {
    public String minWindow(String s, String t) {
        int l=0, r=0, minLen = Integer.MAX_VALUE, startIndex = -1, count=0;
        int n = s.length(), m = t.length();
        int[] hash = new int[256];

        for(int i=0; i<m; i++){
            hash[t.charAt(i)]++;
        }

        while(r<n){
            char rc = s.charAt(r);
            if(hash[rc] > 0){
                count++;
            }
            hash[rc]--;

            while(count == m){
                if((r-l+1) < minLen){
                    minLen = r-l+1;
                    startIndex = l;
                }

                char lc = s.charAt(l);
                hash[lc]++;
                if(hash[lc] > 0){
                    count--;
                }
                l++;
            }
            r++;
        }
        return startIndex == -1 ? "" : s.substring(startIndex, startIndex + minLen);
    }
}