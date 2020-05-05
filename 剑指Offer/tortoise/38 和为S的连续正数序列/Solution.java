package leetcode;

import java.util.ArrayList;

public class Solution {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int low = 1;
        int high = 2;

        while(low < high){
            int cur = (low + high) * (high - low + 1)/2;
            if(cur == sum){
                ArrayList<Integer> list = new ArrayList<>();
                for(int i = low; i <= high ; i ++){
                    list.add(i);
                }
                result.add(list);
                low ++;
            }else if(cur < sum){
                high ++;
            }else{
                //当前窗口值大
                low ++;
            }
        }

        return result;
    }
}