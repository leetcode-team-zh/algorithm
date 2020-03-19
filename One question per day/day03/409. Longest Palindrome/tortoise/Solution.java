package leetcode.d409;

public class Solution {
    public int longestPalindrome(String s) {
        int[] charNums = new int[128];
        for(char c : s.toCharArray()){
            charNums[c] ++;
        }

        int oddNum = 0;
        for(int count : charNums){
            if(count % 2 == 1){
                oddNum ++;
            }
        }

        //最多一个num
        return oddNum == 0 ? s.length() : s.length() - oddNum + 1;
    }
}
