package com.dpc.algorithm.leetcode;

public class Solution {

    /*
    * Only the space character ' ' is considered as whitespace character.
Assume we are dealing with an environment which could only store integers
* within the 32-bit signed integer range: [−231,  231 − 1].
* If the numerical value is out of the range of representable values,
* INT_MAX (231 − 1) or INT_MIN (−231) is returned.*/

    public int myAtoi1(String str) {
        boolean positive = true;
        boolean flag = false;
        boolean numEnc = false;
        int start = -1;
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ' ' && !numEnc) {
                if(flag) break;
            }

            else if ((c == '-' || c == '+') && !flag) { // 遇到了开头的-
                positive = c != '-';
                flag = true;

            } else if (c - '0' > 9 || c - '0' < 0) {// 遇到了非法字符
                return res;
            } else { //遇到的是数字
                numEnc = true;
                if (start == -1 && c != '0') start = i;
                else if (c == '0' && start == -1) {
                    continue;
                }
                //开始遇到可以计算的数字
                if (start != -1 && i + 1 - start <= 10) { //位数没超过
                    long value = Long.parseLong(str.substring(start, i + 1).stripLeading());
                    if (positive && value > Integer.MAX_VALUE) {
                        res = Integer.MAX_VALUE;
                    } else if (!positive && -value < Integer.MIN_VALUE) {
                        res = Integer.MIN_VALUE;
                    } else {
                        res = (int) (positive ? value : -value);
                    }
                } else {
                    if (i + 1 - start > 10) {
                        res = positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                    }
                    break;
                }
            }
        }
        return res;
    }

    public int myAtoi(String str) {
        if(str.isEmpty()) {
            return 0;
        }

        int index=0;
        int startIndex=0;
        boolean negative=false;
        while(str.length()>index && str.charAt(index)==' ') {
            index++;
        }
        if(index>=str.length()) {
            return 0;
        }

        if(str.charAt(index)=='+') {
            index++;
        } else if(str.charAt(index)=='-') {
            index++;
            negative=true;
        }

        if(index>=str.length()) {
            return 0;
        }

        if(Character.isDigit(str.charAt(index))==false) {
            return 0;
        } else {
            startIndex=index;
        }
        int endIndex=startIndex;
        for(int i=startIndex; i<str.length(); i++) {
            if(str.charAt(i)>='0' && str.charAt(i)<='9') {
                endIndex++;
            } else {
                break;
            }
        }
        double num=0;
        for(int i=startIndex; i<endIndex; i++) {
            num=(num*10)+Double.parseDouble(Character.toString(str.charAt(i)));
        }
        if(num>Integer.MAX_VALUE) {
            return (negative)?Integer.MIN_VALUE:Integer.MAX_VALUE;
        }

        return negative?(int)(-1*num):(int)num;
    }

    public static void main(String[] args) {
        String str = "";
        Solution solution = new Solution();
        System.out.println(solution.myAtoi("-   234"));

    }
}

