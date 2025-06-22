// Problem: Divide a String Into Groups of Size k
// Link: https://leetcode.com/problems/divide-a-string-into-groups-of-size-k/description/
// Date : 22-June-2025

package POTD;

class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        int len;
        if(n % k == 0){
            len = n / k;
        }
        else{
            len = n / k + 1;
        }
        StringBuilder sb = new StringBuilder(s);
        if(n % k != 0){
            int extra = k - n % k;
            for(int i=0; i<extra; i++){
                sb.append(fill);
            }
        }
        String[] arr = new String[len];
        int j = 0;
        StringBuilder str = new StringBuilder();
        for(int i=0; i<sb.length(); i++){
            str.append(sb.charAt(i));
            if(str.length() == k){
                arr[j] = str.toString();
                j++;
                str.setLength(0);
            }
        }
        return arr;
    }
}