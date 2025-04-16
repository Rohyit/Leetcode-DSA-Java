// Problem: Container With Most Water
// Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
// Approach: Two pointer

class Solution {
    public int maxArea(int[] height) {
        int left=0, right=height.length-1, maxArea=0;
        while(left<right){
            int h = Math.min(height[left], height[right]);
            int width = right-left;
            int area = h*width;
            maxArea = Math.max(maxArea, area);

            if(height[left]<height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return maxArea;
    }
}