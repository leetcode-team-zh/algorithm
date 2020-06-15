package leetcode.m46;

public class Solution {
    public int translateNum(int num) {
        String src = String.valueOf(num);
        int a = 1;
        int b = 1;
        for(int  i = 2 ; i <= src.length(); i++){
            String tmp = src.substring(i - 2, i);
            int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a + b : a;
            b = a;
            a = c;
        }
        return a;
    }
}
