// Problem: Maximum Product of Two Digits
// Link: https://leetcode.com/contest/weekly-contest-448/problems/maximum-product-of-two-digits/description/
// Contest : Weekly-448

package Contests;
import java.util.*;

class Solution {
    public int maxProduct(int n) {
        List<Integer> list = new ArrayList<>();
        if(n==0){
            return 0;
        }
        while(n>0){
            int r = n%10;
            n = n/10;
            list.add(r);
        }
        int s = list.size();
        int l=0, r= s-1;
        int maxProd = Integer.MIN_VALUE;
        while(l<r){
            int prod = list.get(l)*list.get(r);
            maxProd = Math.max(maxProd, prod);
            if(list.get(l)<list.get(r)){
                l++;
            }
            else{
                r--;
            }
        }
        return maxProd;
    }
}