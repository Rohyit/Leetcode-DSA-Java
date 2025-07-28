// Problem: Capacity To Ship Packages Within D Days
// Link: https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/
// Approach: Binary Search 

 class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int maxi = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0; i<weights.length; i++){
            maxi = Math.max(maxi, weights[i]);
            sum += weights[i];
        }

        int low = maxi;
        int high = sum;

        while(low <= high){
            int mid = (low + high) / 2;

            if(noOfDays(weights, mid) <= days){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return low;
    }
    private int noOfDays(int[] weights, int capacity){
        int days = 1;
        int load = 0;

        for(int i=0; i<weights.length; i++){
            if(load + weights[i] > capacity){
                days = days + 1;
                load = weights[i];
            }
            else{
                load = load + weights[i];
            }
        }
        return days;
    }
}
