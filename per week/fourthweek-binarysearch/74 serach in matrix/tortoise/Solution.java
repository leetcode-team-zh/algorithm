package leetcode.d74;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0){
            return false;
        }

        int rowLen = matrix.length;
        int colLen = matrix[0].length;

        //两次二分查找
        int start = 0;
        int end = rowLen - 1;
        int res = -1;

        while(start <= end){
            int mid = start + (end - start) / 2;
            int value = matrix[mid][colLen - 1];
            if(value ==  target){
                return true;
            }else if(value > target){
                res = mid;
                end = mid -1;
            }else if(value < target){
                start = mid + 1;
            }
        }
        if(res == -1){
            return false;
        }

        start = 0;
        end = colLen - 1;
        while (start <= end){
            int mid = start + (end - start) / 2;
            if(matrix[res][mid] == target){
                return true;
            }else if(matrix[res][mid] < target){
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return false;
    }


    public boolean searchMatrix1(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0){
            return false;
        }

        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int start = 0;
        int end = rowLen * colLen -1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            int value = matrix[mid / colLen][mid % colLen];
            if(value ==  target){
                return true;
            }else if(value > target){
                end = mid -1;
            }else if(value < target){
                start = mid + 1;
            }
        }
        return false;
    }

}
