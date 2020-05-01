package com.dpc.algorithm.day39;

public class Solution {

    // 数组中的逆序对问题
    // 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
    // 示例 1:
    //
    //输入: [7,5,6,4]
    //输出: 5
    //限制：
    //
    //0 <= 数组长度 <= 50000

    int count = 0;

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) return count;
        mergeSort(nums, 0, nums.length - 1);
        return count;
    }


    public void mergeSort(int[] nums, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            // 左边
            mergeSort(nums, low, mid);
            // 右边
            mergeSort(nums, mid + 1, high);
            // 左右归并
            merge(nums, low, mid, high);
        }

    }

    private void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;// 左指针
        int j = mid + 1;// 右指针
        int k = 0;
        // 把较小的数先移到新数组中
        while (i <= mid && j <= high) {
            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
                count += (mid - i + 1);
            }
        }
        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = a[i++];
//            count++;
        }
        // 把右边边剩余的数移入数组
        while (j <= high) {
            temp[k++] = a[j++];
        }
        // 把新数组中的数覆盖nums数组
        for (int k2 = 0; k2 < temp.length; k2++) {
            a[k2 + low] = temp[k2];
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }

            k--;
        }

        if (i < 0) {
            for (; k >= 0; k--) {
                nums1[k] = nums2[j--];
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {7, 5, 6, 4};
//        int[] nums = {1,5, 3, 4};
        System.out.println(solution.reversePairs(nums));
    }

}

