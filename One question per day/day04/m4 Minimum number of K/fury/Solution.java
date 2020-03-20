import java.util.*;

class Solution {

    /*
    * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。



示例 1：

输入：arr = [3,2,1], k = 2
输出：[1,2] 或者 [2,1]
示例 2：

输入：arr = [0,1,2,1], k = 1
输出：[0]


限制：

0 <= k <= arr.length <= 10000
0 <= arr[i] <= 10000*/

    public int[] getLeastNumbers(int[] arr, int k) {
        int[] result = {};
        if (arr == null || k > arr.length || k == 0) return result;
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int i = 0; i < arr.length; i++) {
            if (queue.size() != k) {
                queue.offer(arr[i]);
            } else {
                if (arr[i] < queue.peek()) {
                    queue.poll();
                    queue.offer(arr[i]);
                }
            }
        }
        result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 2, 4, 4, 1, 3, 3, 2};
        Solution solution = new Solution();
        int[] nums = solution.getLeastNumbers(arr, 6);
        for (int i : nums) {
            System.out.print(i + ", ");
        }
    }


}

