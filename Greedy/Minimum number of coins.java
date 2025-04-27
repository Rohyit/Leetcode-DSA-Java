// Problem: Minimum number of coins
// Link: https://www.geeksforgeeks.org/problems/-minimum-number-of-coins4426/1?
// Approach: Greedy 

package Greedy;
import java.util.*;

class Solution {
    static List<Integer> minPartition(int N) {
        List<Integer> list = new ArrayList<>();
        int[] den = {1,2,5,10,20,50,100,200,500,2000};
        int val = N;
        int n = den.length;
        for(int i=n-1; i>=0; i--){
            while(val>=den[i]){
                val=val-den[i];
                list.add(den[i]);
            }
        }
        return list;
    }
}