// Problem: Restore Finishing Order
// Link: https://leetcode.com/problems/restore-finishing-order/description/
// Approach: Hashing

package Hashing;
import java.util.*;

class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        Set<Integer> set = new HashSet<>();
        for(int num : friends){
            set.add(num);
        }
        int[] arr = new int[friends.length];
        int i=0;
        for(int num : order){
            if(set.contains(num)){
                arr[i] = num;
                i++;
            }
        }
        return arr;
    }
}