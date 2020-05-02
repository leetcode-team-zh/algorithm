package leetcode;


public class Solution {
    public int minNumberInRotateArray(int [] array) {
        //3 4 5 1 2
        //5 1 2 3 4
        int left = 0;
        int right = array.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(array[mid]> array[mid + 1]){
                return array[mid + 1];
            }else if(array[mid] > array[array.length - 1]){
                left = mid + 1;
            }else{
                right = mid - 1;
            }

        }
        return -1;
    }
}
