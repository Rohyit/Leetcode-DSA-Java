
// Problem: Fruit Into Baskets
// Link: https://leetcode.com/problems/fruit-into-baskets/description/
// Approach: Hashing

package Hashing;
import java.util.*;

class Solution {
    public int totalFruit(int[] fruits) {
        int maxCount = 0;
        int i=0; 
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int j=0; j<fruits.length; j++){
            map.put(fruits[j], map.getOrDefault(fruits[j], 0)+1);

            while(map.size()>2){
                map.put(fruits[i], map.get(fruits[i])-1);

                if(map.get(fruits[i])==0){
                    map.remove(fruits[i]);
                }
                i++;
            }
            maxCount = Math.max(maxCount, j-i+1);
        }
        return maxCount;
    }
}