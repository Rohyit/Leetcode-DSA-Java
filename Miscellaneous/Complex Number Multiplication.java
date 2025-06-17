// Problem: Complex Number Multiplication
// Link: https://leetcode.com/problems/complex-number-multiplication/description/

package Miscellaneous;

class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        /* 
            num1 = 1+1i, num2 = 2+-1i
            a1 = 1, a2 = 2, b1 = 1, b2 = -1
        */ 
        int n1 = num1.length();
        int n2 = num2.length();

        int a1 = Integer.parseInt(num1.substring(0, num1.indexOf('+')));
        int a2 = Integer.parseInt(num2.substring(0, num2.indexOf('+')));
        int b1 = Integer.parseInt(num1.substring(num1.indexOf('+')+1, n1-1));
        int b2 = Integer.parseInt(num2.substring(num2.indexOf('+')+1, n2-1));

        int real = a1*a2 - b1*b2;
        int comp = a1*b2 + a2*b1;

        // Return String : real + comp i

        StringBuilder s = new StringBuilder();
        s.append(Integer.toString(real));
        s.append("+");
        s.append(Integer.toString(comp));
        s.append("i");

        return s.toString();
    }
}