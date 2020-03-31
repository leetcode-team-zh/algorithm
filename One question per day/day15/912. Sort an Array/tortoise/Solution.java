package leetcode.d912;

public class Solution {
    //归并排序
    public int[] sortArray(int[] nums){
        mergeSort(nums,0,nums.length - 1);
        return nums;
    }


    private void mergeSort(int[] nums, int left, int right) {
        if(left >= right){
            return;
        }
        int mid = (left + right)/2;
        mergeSort(nums,left,mid);
        mergeSort(nums,mid + 1,right);
        merge(nums,left,mid,right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        while(i <= mid && j<= right){
            if(nums[i] < nums[j]){
                tmp[k++] = nums[i++];
            }else {
                tmp[k++] = nums[j++];
            }
        }
        //左边剩余的
        while (i <= mid){
            tmp[k++] = nums[i++];
        }

        //右边剩余的
        while(j <= right){
            tmp[k++] = nums[j++];
        }

        for(int step=0; step < tmp.length; step++){
            nums[step + left] = tmp[step];
        }
    }

    //快速排序
    public int[] sortArray2(int[] nums){
         quickSort(nums,0,nums.length - 1);
         return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        if(left >= right){
            return;
        }
        int dp = partition(nums,left,right);
        quickSort(nums,left,dp -1);
        quickSort(nums,dp + 1,right);
    }

    //一趟快排
    private int partition(int[] nums,int left,int right){
        int pivot = nums[left];
        int i = left;
        int j = right;
        while (i < j){
            while (i < j && nums[j] >= pivot){
                j--;
            }

            while (i < j && nums[i] <= pivot){
                i++;
            }
            swap(nums, i, j);
        }
        swap(nums,left,i);
        return i;
    }

    //冒泡排序
    public int[] sortArray1(int[] nums) {
        for(int i = nums.length -1; i >= 0; i--){
            //4 5 3 6 0
            for(int j = 0; j < i; j++){
                if(nums[j] > nums[j+1]){
                    swap(nums,j,j+1);
                }
            }
        }
        return nums;
    }

    public void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        new Solution().sortArray(new int[]{5,1,1,2,0,0});
    }
}
