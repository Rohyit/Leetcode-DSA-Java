// Problem: Delete Columns to Make Sorted
// Link: https://leetcode.com/problems/delete-columns-to-make-sorted/description/
// Date : 20-Dec-2025

package POTD;

class Solution {
    public int minDeletionSize(String[] strs) {
        int count = 0;
        for(int i=0; i<strs[0].length(); i++){
            for(int j=1; j<strs.length; j++){
                if(strs[j].charAt(i) < strs[j-1].charAt(i)){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}