// Problem: Can Place Flowers
// Link: https://leetcode.com/problems/can-place-flowers/description/
// Approach: Greedy 

package Greedy;

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;

        int i = 0;

        if(n == 0){
            return true;
        }

        if(len == 1 && flowerbed[0] == 0){
            return n <= 1;
        }

        if(i == 0 && flowerbed[i] == 0 && flowerbed[i+1] == 0){
            n--;
            flowerbed[i] = 1;

            if(n == 0){
                return true;
            }
        }

        for(i = 1; i < len-1; i++){
            if(flowerbed[i] == 0 && flowerbed[i-1] == 0 && flowerbed[i+1] == 0){
                n--;
                flowerbed[i] = 1;
            }
            if(n == 0){
                return true;
            }
        }

        if(i == len - 1 && flowerbed[i] == 0 && flowerbed[i-1] == 0){
            n--;
            flowerbed[i] = 1;

            if(n == 0){
                return true;
            }
        }
    
        return false;
    }
}