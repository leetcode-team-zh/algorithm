package leetcode;


import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int NumberOf1(int n) {
        int num = 0;
        while(n != 0){
            num += n & 1;
            n  = n >>> 1;
        }
        return num;
    }
}
