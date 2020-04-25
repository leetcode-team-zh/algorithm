package leetcode.m51;

import java.util.Arrays;

public class Solution {
//    public int reversePairs(int[] nums) {
//
//         if(nums == null || nums.length < 2){
//             return 0;
//         }
//        int len = nums.length;
//        int[] copy = Arrays.copyOf(nums,len);
//        int[] temp = new int[len];
//        return reversePairs(copy,0,len - 1, temp);
//    }
//
//    private int reversePairs(int[] nums, int left, int right, int[] temp) {
//        if(left == right){
//            return 0;
//        }
//
//        int mid = left + (right - left) / 2;
//        int leftPairs = reversePairs(nums,left,mid,temp);
//        int rightPairs = reversePairs(nums,mid + 1,right,temp);
//
//        //如果整个数组已经有序，则无需合并
//        if(nums[mid] <= nums[mid + 1]){
//            return leftPairs + rightPairs;
//        }
//        int crossPairs = mergeAndCount(nums,left,mid,right,temp);
//        return leftPairs + rightPairs + crossPairs;
//    }
//
//    private int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
//        for(int i = left; i <= right; i++){
//            temp[i] = nums[i];
//        }
//
//        int i = left;
//        int j = mid + 1;
//
//        int count = 0;
//        for(int k = left; k <= right; k++){
//            if(i == mid + 1){
//                nums[k] = temp[j];
//                j ++;
//            }else if(j == right + 1){
//                nums[k] = temp[i];
//                i++;
//            }else if(temp[i] <= temp[j]){
//                nums[k] = temp[i];
//                i++;
//            }else{
//                nums[k] = temp[j];
//                j++;
//                 count += (mid - i + 1);
//            }
//        }
//        return count;
//    }

    public int reversePairs(int[] nums) {

        if(nums == null || nums.length < 2){
            return 0;
        }
        return reversePairs(nums,0,nums.length - 1);
    }

    private int reversePairs(int[] nums, int left, int right) {
        if(left < right){
            int mid = left + (right - left) / 2;
            int leftPairs = reversePairs(nums,left,mid);
            int rightPairs = reversePairs(nums,mid + 1,right);
            if(nums[mid] <= nums[mid + 1]){
                return leftPairs + rightPairs;
            }
            int crossPairs = merge(nums,left,mid,right);
            return leftPairs + rightPairs + crossPairs;
        }else{
            return 0;
        }
    }

    private int merge(int[] nums, int left, int mid, int right) {
        int[] tmp=new int[nums.length];//辅助数组

        int i = left;
        int j = mid + 1;
        int k = left;
        int count = 0;

        while(i <= mid && j <= right){
            if(nums[i] <= nums[j]){
                tmp[k++] = nums[i++];
            }else{
                tmp[k++] = nums[j++];
                count += (mid - i + 1);
            }
        }

        while(i <= mid){
            tmp[k++] = nums[i++];
        }

        while(j <= right){
            tmp[k++] = nums[j++];
        }

        for(int u = left; u <= right; u++){
            nums[u] = tmp[u];
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reversePairs(new int[]{7,5,6,4}));
    }


}
