// Problem: Count Square Sum Triples
// Link: https://leetcode.com/problems/count-square-sum-triples/description/
// Date : 08-Dec-2025

package POTD;

class Solution {
    public int countTriples(int n) {
        int count = 0;
        for(int i=1; i<n-1; i++){
            for(int j= i+1; j<n; j++){
                for(int k = j+1; k<=n; k++){
                    if(i*i + j*j == k*k){
                        count++;
                    }
                }
            }
        }
        return count*2;
    }
}