//一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
    //示例 1：
    //
    //输入：nums = [4,1,4,6]
    //输出：[1,6] 或 [6,1]

    //示例 2：
    //
    //输入：nums = [1,2,10,4,1,4,3,3]
    //输出：[2,10] 或 [10,2]

    //限制：
    //
    //2 <= nums <= 10000

    public int[] singleNumbers(int[] nums) {
        int res0 = 0, res1 = 0;
        int sum = 0;
        for (int num : nums) sum ^= num;
        int i = 0;
        while (i < 32) {
            if ((sum >> i & 1) == 1) break;
            i++;
        }
        if (i < 32) {
            for (int num : nums) {
                if ((num >> i & 1) == 1) res1 ^= num;
                else res0 ^= num;
            }
        }
        return new int[]{res0, res1};
    }

    public int[] singleNumber(int[] nums) {
        int res0 = 0, res1 = 0;
        int sum = 0;
        for (int num : nums) sum ^= num;
        int i = 0;
        while (i < 32) {
            if ((sum >> i & 1) == 1) break;
            i++;
        }
        if (i < 32) {
            for (int num : nums) {
                if ((num >> i & 1) == 1) res1 ^= num;
                else res0 ^= num;
            }
        }
        return new int[]{res0, res1};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {7, 1, 7, 2, 6, 6, 3, 1};
        int[] res = solution.singleNumbers(nums);
        for (int re : res) {
            System.out.println(re);
        }
    }
