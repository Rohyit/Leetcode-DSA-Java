// Problem: Koko Eating Bananas
// Link: https://leetcode.com/problems/koko-eating-bananas/description/
// Approach: Binary Search 

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int maxRange = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            if(piles[i] > maxRange){
                maxRange = piles[i];
            }
        }

        int low = 1;
        int high = maxRange;

        while(low <= high){
            int mid = (low + high)/2;
            int totalhour = totalHours(piles, mid);
            if(totalhour <= h){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }
    private int totalHours(int[] piles, int speed){
        int len = piles.length;
        int totalhour = 0;
        for(int i=0; i< len; i++){
            totalhour += Math.ceil((double)piles[i] / (double)speed);
        }
        return totalhour;
    }
}