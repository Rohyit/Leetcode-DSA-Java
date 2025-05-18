// Problem: Find Closest Person
// Link: https://leetcode.com/problems/find-closest-person/description/
// Contest : Weekly-445

package Contests;

class Solution {
    public int findClosest(int x, int y, int z) {
        int one = Math.abs(x-z);
        int two = Math.abs(y-z);

        if(one == two){
            return 0;
        }
        else if(one<two){
            return 1;
        }
        else{
            return 2;
        }
    }
}