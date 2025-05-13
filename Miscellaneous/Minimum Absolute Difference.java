// Problem: Minimum Absolute Difference
// Link: https://leetcode.com/problems/minimum-absolute-difference/description/

package Miscellaneous;
import java.util.*;

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> list = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;
        for(int i=1; i<arr.length; i++){
            if(arr[i]-arr[i-1]<minDiff){
                minDiff = arr[i]-arr[i-1];
                list.clear();
                List<Integer> ans = new ArrayList<>();
                ans.add(arr[i-1]);
                ans.add(arr[i]);
                list.add(ans);
            }
            else if(arr[i]-arr[i-1]==minDiff){
                minDiff = arr[i]-arr[i-1];
                List<Integer> ans = new ArrayList<>();
                ans.add(arr[i-1]);
                ans.add(arr[i]);
                list.add(ans);
            }
        }
        return list;
    }
}