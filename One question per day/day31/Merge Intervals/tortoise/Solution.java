package leetcode.d56;

import java.util.Arrays;

public class Solution {
    public int[][] merge(int[][] intervals) {
        //按左端点排序
        Arrays.sort(intervals,(o1,o2) -> o1[0] - o2[0]);

        int[][] result = new int[intervals.length][2];

        int index = -1;
        for(int[] interval : intervals){
            if(index == -1 || interval[0] > result[index][1]){
                result[++index] = interval;
            }else {
                //可以合并,其实更新右端点
                result[index][1] = Math.max(interval[1],result[index][1]);
            }
        }
        return Arrays.copyOf(result,index + 1);
    }
}
