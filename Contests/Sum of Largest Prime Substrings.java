// Problem: Sum of Largest Prime Substrings
// Link: https://leetcode.com/contest/biweekly-contest-157/problems/sum-of-largest-prime-substrings/description/
// Contest : Bi-Weekly-157

package Contests;
import java.util.*;
import java.math.BigInteger;

class Solution {
    public long sumOfLargestPrimes(String s) {
        Set<Long> set = new HashSet<>();

        for(int i=0; i<s.length(); i++){
            for(int j=i; j<s.length(); j++){
                
                long n = Long.parseLong(s.substring(i, j+1));
                if(n>1 && BigInteger.valueOf(n).isProbablePrime(10)){
                    set.add(n);
                }
            }
        }
        List<Long> list = new ArrayList<>(set);
        if(set.isEmpty()){
            return 0;
        }
        Collections.sort(list, Collections.reverseOrder());
        long sum = 0;
        for(int i=0; i<Math.min(3, list.size()); i++){
            sum += list.get(i);
        }
        return sum;
    }
}