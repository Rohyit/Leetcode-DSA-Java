// Problem: Count Collisions on a Road
// Link: https://leetcode.com/problems/candy/description/
// Date : 04-Dec-2025

package POTD;

class Solution {
    public int countCollisions(String directions) {
        int n = directions.length();
        if(n == 1){
            return 0;
        }
        int i=0;
        while(i != n && directions.charAt(i) == 'L'){
            i++;
        }
        int j = n-1;
        while(j != 0 && directions.charAt(j) == 'R'){
            j--;
        }
        int count = 0;
        for(int k = i; k <= j; k++){
            if(directions.charAt(k) != 'S'){
                count++;
            }
        }
        return (int)count;
    }
}