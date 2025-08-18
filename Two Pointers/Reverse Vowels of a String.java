// Problem: Reverse Vowels of a String
// Link: https://leetcode.com/problems/reverse-vowels-of-a-string/description/
// Approach: Two pointer

// T.C. : O(n)
// S.C. : O(n)

class Solution {
    public String reverseVowels(String s) {
        int left=0, right = s.length()-1;
        String vowels = "aeiouAEIOU";
        char[] arr = s.toCharArray();
        while(left<right){
            while(left<right && vowels.indexOf(arr[left])== -1){
                left++;
            }
            while(left<right && vowels.indexOf(arr[right])== -1){
                right--;
            }
            char temp = arr[left];
            arr[left]=arr[right];
            arr[right]= temp;
            left++;
            right--;
        }
        return new String(arr);
    }
}