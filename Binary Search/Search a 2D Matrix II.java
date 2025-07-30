// Problem: Search a 2D Matrix II
// Link: https://leetcode.com/problems/search-a-2d-matrix-ii/description/
// Approach: Binary Search 

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean flag = false;
        
        for(int i=0; i<matrix.length; i++){
            flag = binarySearch(matrix[i], target);
            if(flag == true){
                return true;
            }
        }
        return flag;
    }
    private boolean binarySearch(int[] arr, int target){
        int n = arr.length;
        int low = 0;
        int high = n - 1;

        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] == target){
                return true;
            }
            else if(arr[mid] > target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return false;
    }
}