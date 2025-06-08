// Problem: Transform Array to All Equal Elements
// Link: https://leetcode.com/problems/transform-array-to-all-equal-elements/
// Contest : Weekly-453

package Contests;
import java.util.*;

class Solution {
    public boolean canMakeEqual(int[] nums, int k) {
        int n = nums.length;
        int[] pos = new int[n];
        int[] neg = new int[n];

        Set<Integer> setPos = new HashSet<>();
        Set<Integer> setNeg = new HashSet<>();

        for(int i = 0; i < n; i++){
            pos[i] = nums[i];
            setPos.add(pos[i]);
        }
        if(setPos.size() == 1){
            return true;
        }

        for(int i = 0; i < n; i++){
            neg[i] = nums[i];
            setNeg.add(neg[i]);
        }
        if(setNeg.size() == 1){
            return true;
        }

        setPos.clear();
        setNeg.clear();

        int cntPos = 0;
        int cntNeg = 0;

        for(int i=0; i<n-1; i++){
            if(pos[i] == -1){
                pos[i] = 1;
                pos[i+1] = -pos[i+1];
                cntPos++;
            }
        }
        for(int i=0; i<n; i++){
            setPos.add(pos[i]);
        }

        for(int i=0; i<n-1; i++){
            if(neg[i] == 1){
                neg[i] = -1;
                neg[i+1] = -neg[i+1];
                cntNeg++;
            }
        }
        for(int i=0; i<n; i++){
            setNeg.add(neg[i]);
        }

        if((cntPos > 0 && cntPos <= k && setPos.size()==1) || cntNeg > 0 && cntNeg <= k && setNeg.size()==1){
            return true;
        }
        return false;
    }
}