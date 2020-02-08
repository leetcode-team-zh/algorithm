package leetcode.d191;

public class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        int mask = 1;

        int i = 0;
        while(i < 32){
            if((n & mask) != 0){
                count ++;
            }
            n >>= 1; //n 右移
            i++;
        }
        return count;
    }

    public static void main(String[] args) {
        new Solution().hammingWeight(00000000000000000000000000001011);
    }
}
