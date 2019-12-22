package leetcode.d50;

public class Solution {
    public double myPow(double x, int n) {
        //如果小于0，使用x 的 倒数，求指数
        x = n > 0 ? x : 1 / x ;
         //分治法
        double result = pow(x,Math.abs(n));
        return result;
    }

    public double pow(double x,int n){
        if(n == 0){
            return 1;
        }
        double half = pow(x,n/2);
        if(n % 2 == 0){
            return half * half;
        }else {
            return half * half * x;
        }
    }

    public static void main(String[] args) {
        new Solution().myPow(2,5);
    }
}
