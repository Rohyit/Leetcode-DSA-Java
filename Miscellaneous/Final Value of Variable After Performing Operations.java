// Problem: Final Value of Variable After Performing Operations
// Link: https://leetcode.com/problems/final-value-of-variable-after-performing-operations/description/

package Miscellaneous;

class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for(int i=0; i<operations.length; i++){
            if(operations[i].equals("X++") || operations[i].equals("++X")){
                x++;
            }
            else x--;
        }
        return x;
    }
}