package leetcode.d153;

import com.sun.corba.se.impl.interceptors.SlotTable;

public class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums[nums.length -1] >= nums[0]){
            return nums[0];
        }

        int start = 0;
        int end = nums.length - 1;
        while (start <= end){
            int mid = start + (end - start) / 2;

//            if(nums[mid] > nums[mid+1]){
//                return nums[mid + 1];
//            }
//            if(nums[mid] < nums[mid -1]) {
//                return nums[mid];
//            }
            if(end - start == 1){
                return nums[end];
            }

            if(nums[mid] > nums[end]){
                start = mid;
            }else{
                end = mid;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {1,2};
        new Solution().findMin(nums);
    }
}
