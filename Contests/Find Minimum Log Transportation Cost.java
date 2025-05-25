// Problem: Find Minimum Log Transportation Cost
// Link: https://leetcode.com/problems/find-minimum-log-transportation-cost/description/
// Contest : Weekly-451

package Contests;

class Solution {
    public long minCuttingCost(int n, int m, int k) {
        if(n<=k && m<=k){
            return 0;
        }
        if(n>k){
            return (long)(n-k)*k;
        }
        return (long)(m-k)*k;
    }
}
