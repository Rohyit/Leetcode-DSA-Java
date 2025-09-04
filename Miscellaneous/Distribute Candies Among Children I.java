// Problem: Distribute Candies Among Children I
// Link: https://leetcode.com/problems/distribute-candies-among-children-i/

// T.C. : O(n^2)
// S.C. : O(1)

package Miscellaneous;

class Solution {
    public int distributeCandies(int n, int limit) {
        int count = 0;
        for(int i = 0; i <= limit && i <= n; i++){
            for(int j = 0; j <= limit && j <= n; j++){
                if(n-i-j <= limit && n-i-j >= 0){
                    count++;
                }
            }
        }
        return count;
    }
}