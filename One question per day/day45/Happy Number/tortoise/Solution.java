package leetcode.d202;

public class Solution {
    public boolean isHappy(int n) {
        int slowRunner = n;
        int fastRunner = getNextNum(n);
        while(fastRunner != 1 && slowRunner != fastRunner){
            slowRunner = getNextNum(slowRunner);
            fastRunner = getNextNum(getNextNum(fastRunner));
        }
        return fastRunner == 1;
    }

    private int getNextNum(int num){
        int totalSum = 0;
        while(num > 0){
            int digit = num % 10;
            totalSum += Math.pow(digit,2);
            num = num/ 10;
        }
        return totalSum;
    }
}
