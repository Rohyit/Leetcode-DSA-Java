
// Problem: Happy Number
// Link: https://leetcode.com/problems/happy-number/description/
// Approach: Hashing

package Hashing;
import java.util.*;

class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<Integer>();
        while(n != 1 && !set.contains(n)){
            set.add(n);
            n = sumOfNumber(n);
        }
        return n==1;
    }
    public int sumOfNumber(int n){
        int sum = 0;
        while(n>0){
            int digit = n%10;
            sum += digit*digit;
            n /= 10;
        }
        return sum;
    }
}