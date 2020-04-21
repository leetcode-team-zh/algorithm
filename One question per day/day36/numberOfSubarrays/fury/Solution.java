 // 1248 优美子数组问题 1248. Count Number of Nice Subarrays
//    Given an array of integers nums and an integer k. A subarray is called nice if there are k odd numbers on it.
//
//    Return the number of nice sub-arrays.

    // Example 1:
    //
    //Input: nums = [1,1,2,1,1], k = 3
    //Output: 2
    //Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].

    //Example 2:
    //
    //Input: nums = [2,4,6], k = 1
    //Output: 0
    //Explanation: There is no odd numbers in the array.

    //Example 3:
    //
    //Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
    //Output: 16

    //Constraints:
    //
    //1 <= nums.length <= 50000
    //1 <= nums[i] <= 10^5
    //1 <= k <= nums.length
    // 思路 k 滑动窗口
    public int numberOfSubarrays(int[] nums, int k) {
        int len = nums.length;
        int count = 0;
        int oddNum = 0;
        int[] oddIndex = new int[len + 2];
        for (int i = 0; i < len; i++) {
            if (nums[i] % 2 == 1) oddIndex[++oddNum] = i;
        }
        oddIndex[0] = -1; // 左边界
        oddIndex[oddNum + 1] = len; // 右边界

        for (int i = 1; i + k <= oddNum + 1; i++) {
            count += (oddIndex[i] - oddIndex[i - 1]) * (oddIndex[i + k] - oddIndex[i + k - 1]);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arrays = {2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
        Solution solution = new Solution();
        System.out.println(solution.numberOfSubarrays(arrays, 2));
    }
