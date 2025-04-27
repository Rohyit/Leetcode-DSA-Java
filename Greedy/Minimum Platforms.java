// Problem: Minimum Platforms
// Link: https://www.geeksforgeeks.org/problems/minimum-platforms-1587115620/1?
// Approach: Greedy 

package Greedy;
import java.util.*;

class Solution {
    static int findPlatform(int arr[], int dep[]) {
        int n = arr.length;
        int m = dep.length;
        
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int i=0, j=0;
        
        int count = 0;
        int maxCount = 0;
        
        while(i<n && j<m){
            if(arr[i]<=dep[j]){
                count++;
                i++;
            }
            else{
                count--;
                j++;
            }
            maxCount = Math.max(count, maxCount);
        }
        return maxCount;
    }
}
