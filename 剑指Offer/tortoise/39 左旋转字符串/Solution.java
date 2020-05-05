package leetcode;

import java.util.ArrayList;

public class Solution {
    public String LeftRotateString(String str,int n) {
        if(str == null || str.length() ==0 || n <= 0){
            return str;
        }

        n = n % str.length();

        return str.substring(n,str.length()) + str.substring(0,n);

    }

    public static void main(String[] args) {
        System.out.println(new Solution().LeftRotateString("abcdefg",3));
    }
}