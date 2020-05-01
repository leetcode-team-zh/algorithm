package leetcode.d34;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        //两次二分查找
        int[] result = new int[]{-1,-1};

        int leftIndex = binarySearch(nums,target,true);
        //如果左边界没找到，说明没有该元素，直接返回
        if(leftIndex == nums.length || nums[leftIndex] != target){
            return result;
        }
        result[0] = leftIndex;

        //如果存在左边界，那肯定存在右边界
        int rightIndex = binarySearch(nums,target,false) - 1;
        result[1] = rightIndex;
        return result;
    }

    /**
     *  flag 为 false
     * @param nums
     * @param target
     * @param left
     * @return
     */
    private int binarySearch(int[] nums,int target,boolean left){
        int start = 0;
        int end = nums.length;

        while(start < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target ){
                if(left){
                    end = mid;
                }else {
                    start = mid + 1;
                }
            }else if(nums[mid] > target){
                end = mid;
            }else if(nums[mid] < target){
                start = mid + 1;
            }
        }
        return start;
    }


    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        new Solution().searchRange(nums,8);
    }
}
