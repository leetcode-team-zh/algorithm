package leetcode.d69;

public class Solution {
    public int mySqrt(int x) {
        if(x == 0) return 0;
        int left = 0;
        int right = x;


        while(left <= right){
            int mid = left + (right - left)/2;
            if((long)mid * mid <= x){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return left - 1;
    }
}
