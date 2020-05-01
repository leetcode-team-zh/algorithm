package leetcode.d33;

public class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target){
                return mid;
            }

            if(nums[start] <= nums[mid]){
                //前半部分有序(3 4 5 6 7 1 2)
                if(target >= nums[start] && target < nums[mid]){
                    end = mid - 1;
                }else {
                    start = mid + 1;
                }
            }else if(nums[start] > nums[mid]){
                //后半部分有序(6 7 1 2 3 4 5)
                if(target <= nums[end] && target > nums[mid]){
                    start = mid + 1;
                }else {
                    end = mid -1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        new Solution().search(nums,0);
    }
}
