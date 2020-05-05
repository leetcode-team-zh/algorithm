package leetcode;

public class Solution {
    public double Power(double base, int exponent) {
        if(base == 0){
            return 0;
        }

        double result = 1;
        int e = exponent > 0 ? exponent : -exponent;
        for(int i=1 ;i<= e; i++){
            result *= base;
        }

        return exponent > 0 ? result : 1 /result;
    }
}
