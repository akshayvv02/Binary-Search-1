/*
 * Performs binary search on a 2D matrix by treating it as a flattened 1D array.
 * 1. n: number of columns in the matrix.
 * 2. Total elements = rows * columns; indices range from 0 to (rows * columns - 1).

 * - searchMatrix(): calculates total number of elements and calls binary search on virtual 1D index range.
 * - binarySearch(): maps 1D index to 2D using (row = mid / n, col = mid % n),
 *   compares with target, and moves search space left or right accordingly.
 */
// Time Complexity : O(log(m * n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix[0].length;
        int r = matrix.length * n;
        return (binarySearch(matrix, 0, r-1, target, n));
    }
    boolean binarySearch(int arr[][], int l, int r, int x, int n) 
    { 
        while(r>=l)
        {
            int mid = (l+r)/2;
            if(arr[mid/n][mid%n] == x)
                return true;;
            //if x is greater than middle element then we move right side of middle element
            if(x>arr[mid/n][mid%n])
                l = mid + 1;
            //if x is lesser than middle element then we move left side of middle element
            else if(arr[mid/n][mid%n]>x)
                r = mid-1;
        }
        return false;
    }
}
