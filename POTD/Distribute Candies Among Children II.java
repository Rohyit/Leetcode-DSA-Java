// Problem: Distribute Candies Among Children II
// Link: https://leetcode.com/problems/distribute-candies-among-children-ii/
// Date : 01-June-2025

package POTD;

class Solution {
    public long distributeCandies(int n, int limit) {
        long count = 0;
        for(int i = Math.max(0, n-2*limit); i <= Math.min(limit, n); i++){
            int secondMin = Math.max(0, n-i-limit);
            int secondMax = Math.min(limit, n-i);
            count += secondMax - secondMin + 1;
        }
        return count;
    }
}