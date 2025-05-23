// Problem: Count Symmetric Integers
// Link: https://leetcode.com/problems/count-symmetric-integers/description/

package Miscellaneous;

class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int cnt = 0;
        for(int i=low; i<=high; i++){
            int count = 0;
            int num = i;
            int temp = num;

            while(temp>=1){
                temp /= 10;
                count++;
            }
            if(count % 2 != 0){
                continue;
            }

            int[] digits = new int[count];

            temp = num;
            for(int j = count - 1; j>=0; j--){
                digits[j] = temp % 10;
                temp /= 10;
            }

            int sumLast = 0;
            for(int j = count/2; j<count; j++){
                sumLast += digits[j];
            }

            int sumFirst = 0;
            for(int j = 0; j<count/2; j++){
                sumFirst += digits[j];
            }
            
            if(sumFirst == sumLast){
                cnt++;
            }
        }
        return cnt;
    }
}