package leetcode.d190;

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        int count = 0;
        while (count < 32){
            result <<= 1; //左移一位
            result |= (n & 1);
            n >>= 1;
            count++;
        }
        return result;
    }
}
