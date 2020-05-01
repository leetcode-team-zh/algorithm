package leetcode.d29;

public class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == 0){
            return -1;
        }

        if(dividend == 0){
            return 0;
        }


        //判断符号位，出错（改为异或判断）
        boolean negative = (dividend ^ divisor) < 0;

        //出错后，加上的
        if (dividend == Integer.MIN_VALUE ){
            if(divisor == 1){
                return Integer.MIN_VALUE;
            }else if(divisor == -1){
                return Integer.MAX_VALUE;
            }
        }

        //出错，改为long
        long divisorTmp  = Math.abs(Long.valueOf(divisor));
        long dividendTmp = Math.abs(Long.valueOf(dividend));
        int res = 0;

        while(divisorTmp <= dividendTmp){
            //如果倍增，超过，则需要初始化
            long subtracted = divisorTmp;
            int count = 1;
            while(subtracted <= dividendTmp){
                dividendTmp -= subtracted;
                res += count;
                count += 1;
                subtracted = divisorTmp * count;
            }
        }

        if(negative){
            res = -res;
        }

        return res;
    }

    public static void main(String[] args) {
        new Solution().divide(7,-3);
    }
}
