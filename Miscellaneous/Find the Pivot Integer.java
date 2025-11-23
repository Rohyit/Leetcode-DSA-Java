// Problem: Find the Pivot Integer
// Link: https://leetcode.com/problems/find-the-pivot-integer/description/

package Miscellaneous;

class Solution {
    public int pivotInteger(int n) {
        for(int i=1; i<=n; i++){
            if(sumTillPivot(i) == sumFromPivotTillN(i, n)){
                return i;
            }
        }
        return -1;
    }
    public int sumTillPivot(int x){
        return x*(x+1)/2;
    }
    public int sumFromPivotTillN(int x, int n){
        return sumTillPivot(n) - sumTillPivot(x-1);
    }
}