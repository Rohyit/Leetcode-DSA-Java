// Problem: Find the Peak Element II
// Link: https://leetcode.com/problems/find-a-peak-element-ii/description/
// Approach: Binary Search 

class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        return binarySearch(mat, n, m);
    }
    private int maxElementInCol(int[][] mat, int mid, int m){
        int maxi = -1;
        int ind = -1;
        for(int i=0; i<m; i++){
            if(mat[i][mid] > maxi){
                maxi = mat[i][mid];
                ind = i;
            }

        }
        return ind;
    }
    private int[] binarySearch(int[][] mat, int n, int m){
        int low = 0;
        int high = n-1;
        int maxInd = -1;
        int mid = -1;

        while(low <= high){
            mid = (low + high) / 2;
            maxInd = maxElementInCol(mat, mid, m);

            int left = (mid - 1 >= 0) ? mat[maxInd][mid - 1] : -1;
            int right = (mid + 1 <= n-1) ? mat[maxInd][mid + 1] : -1;


            if(left < mat[maxInd][mid] && mat[maxInd][mid] > right){
                return new int[]{maxInd, mid};
            }
            else if(left > mat[maxInd][mid]){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return new int[]{maxInd, mid};
    }
}