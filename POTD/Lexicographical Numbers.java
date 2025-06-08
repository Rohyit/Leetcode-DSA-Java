// Problem: Lexicographical Numbers
// Link: https://leetcode.com/problems/lexicographical-numbers/description/
// Date : 08-June-2025

package POTD;
import java.util.*;

class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        int cnt = 1;

        for(int i = 0; i<n; i++){
            list.add(cnt);
            if(cnt * 10 <= n){
                cnt *= 10;
            }
            else{
                if(cnt >= n){
                    cnt /= 10;
                }
                cnt++;
                while(cnt % 10 == 0){
                    cnt /= 10;
                }
            }
        }

        return list;
    }
}