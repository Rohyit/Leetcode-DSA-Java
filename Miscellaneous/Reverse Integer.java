package Miscellaneous;

class Solution {
    public int reverse(int x) {
        int copy = x;
        if(x < 0){
            x = -x;
        }
        int res = 0;
        while(x>0){
            int digit = x % 10;
            if (res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 && digit > 7)) 
                return 0;
            res = (res * 10) + digit;
            x /= 10;
        }
        if(copy<0){
            return -res;
        }
        return res;
    }
}
