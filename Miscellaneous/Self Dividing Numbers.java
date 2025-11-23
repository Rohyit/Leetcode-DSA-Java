// Problem: Self Dividing Numbers
// Link: https://leetcode.com/problems/self-dividing-numbers/description/

package Miscellaneous;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for(int num = left; num <= right; num++){
            int copy = num;
            boolean flag = true;
            while(copy > 0){
                int rem = copy % 10;
                if(rem == 0){
                    flag = false;
                    break;
                }
                if(num % rem != 0){
                    flag = false;
                    break;
                }
                copy /= 10;
            }
            if(flag){
                list.add(num);
            }
        }
        return list;
    }
}