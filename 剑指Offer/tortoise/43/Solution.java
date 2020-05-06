package leetcode;

import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> result = new ArrayList<>();
        if(num == null || num.length == 0 || size <= 0){
            return result;
        }

        //0,1,2,3
        int maxIndex = -1;
        for(int i = 0; i + size <= num.length; i++){
            //最大值在当前窗口内
            if(maxIndex >= i && maxIndex < i + size -1){
                //比较最大值和 窗口最右边的值
                if(num[maxIndex] <= num[i + size -1] ){
                    maxIndex = i + size -1;
                }
            }else {
                //不在的当前窗口类
                maxIndex = getMax(num, i, i + size - 1);
            }
            result.add(num[maxIndex]);
        }
        return result;
    }

    private int getMax(int[] num, int start, int end) {
        int max = num[start];
        int maxIndex = start;
        for(int i = start + 1 ; i <= end; i++){
            if(num[i] >= max){
                max = num[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}