 //33. Search in Rotated Sorted Array
    //假设按照升序排序的数组在预先未知的某个点上进行了旋转。
    //
    //( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
    //
    //搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
    //
    //你可以假设数组中不存在重复的元素。
    //
    //你的算法时间复杂度必须是 O(log n) 级别。
    //
    //示例 1:
    //
    //输入: nums = [4,5,6,7,0,1,2], target = 0
    //输出: 4

    //示例 2:
    //
    //输入: nums = [4,5,6,7,0,1,2], target = 3
    //输出: -1

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target)
                return mid;

            if (nums[start] <= nums[mid]) {
                if (target < nums[mid] && target >= nums[start])
                    end = mid - 1;
                else
                    start = mid + 1;
            }

            if (nums[mid] <= nums[end]) {
                if (target > nums[mid] && target <= nums[end])
                    start = mid + 1;
                else
                    end = mid - 1;
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {5, 1, 3};
        int[] nums1 = {4, 5, 6, 7, 8, 1, 2};
        int[] nums3 = {1, 2, 3, 4, 5};
        Solution solution = new Solution();
        System.out.println(solution.search(nums1, 8));
    }
}
