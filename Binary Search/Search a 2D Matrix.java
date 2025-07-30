// Problem: Search a 2D Matrix
// Link: https://leetcode.com/problems/search-a-2d-matrix/description/
// Approach: Binary Search 

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {    
        return binarySearch(matrix, target);
    }
    private boolean binarySearch(int[][] arr, int target){
        int n = arr.length;
        int m = arr[0].length;
        int low = 0;
        int high = n*m - 1;

        while(low <= high){
            int mid = (low + high) / 2;
            int row = mid / m;
            int col = mid % m;
            if(arr[row][col] == target){
                return true;
            }
            else if(arr[row][col] > target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return false;
    }
}