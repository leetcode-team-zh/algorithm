package leetcode.m40;

/**
 * top n
 */
public class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if( k == 0){
            return new int[0];
        }else if(arr.length <= k){
            return arr;
        }

        //划分partition
        partitionArray(arr,0,arr.length -1 ,k);

        int[] result = new int[k];
        for(int i = 0 ; i < k ; i++){
            result[i] = arr[i];
        }
        return result;
    }


    private void partitionArray(int[] nums,int left,int right,int k){
        int m = partition(nums,left,right);
        if(k == m){
        }else if(k < m){
            //在 左边
            partitionArray(nums,left,right -1,k);
        }else {
            //在右边
            partitionArray(nums,left + 1,right,k);
        }
    }

    private int partition(int[] nums,int left,int right){
        //5,3,6,2,1,7
        int base = nums[left];
        int i = left;
        int j = right;
        while(i < j){
            while(i < j && nums[j] >= base) j--;
            while(i < j && nums[i] <= base) i++;
            swap(nums,i,j);
        }
        //i 和 j 相遇
        swap(nums,left,i);
        return i;
    }

    private void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        new Solution().getLeastNumbers(new int[]{0,0,1,2,4,2,2,3,1,4},8);
    }



}
