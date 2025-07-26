// Problem: Minimum Number of Days to Make m Bouquets
// Link: https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/description/
// Approach: Binary Search 

class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        long val = (long)m * (long)k;
        if(bloomDay.length < val){
            return -1;
        }

        int maxi = Integer.MIN_VALUE;
        int mini = Integer.MAX_VALUE;
    
        for(int i=0; i<bloomDay.length; i++){
            maxi = Math.max(maxi, bloomDay[i]);
            mini = Math.min(mini, bloomDay[i]);
        }
    
        int low = mini;
        int high = maxi;

        while(low <= high){
            int mid = (low + high) / 2;
            if(possible(bloomDay, m, k, mid)){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }
    private boolean possible(int[] bloomDay, int m, int k, int day) {
        int n = bloomDay.length;
        int total = 0;
        int cnt = 0;
        for(int i = 0; i < n; i++){
            if(bloomDay[i] <= day){
                cnt++;
            }
            else{
                total += cnt / k;
                cnt = 0;
            }
        }
        total += cnt / k;

        if(total >= m){
            return true;
        }
        else{
            return false;
        }
    }
}