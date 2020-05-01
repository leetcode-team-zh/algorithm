class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        if(nums[0] < nums[nums.length - 1]){
            return nums[0];
        }

        int start = 0;
        int end = nums.length -1;
        int mid;
        while(start <= end){
            mid = (start + end) /2;

            if(nums[mid+1] < nums[mid]){
                return nums[mid+1];
            }
            if(nums[mid-1] > nums[mid]){
                return nums[mid];
            }
            if(nums[mid] > nums[end]){
                start = mid+1;
            }else  if(nums[mid] < nums[end] ){
                end = mid - 1;
            }
        }
        return -1;

    }
}
