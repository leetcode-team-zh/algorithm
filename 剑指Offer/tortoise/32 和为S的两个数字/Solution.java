package leetcode;

import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        //双指针
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0;
        int j = array.length - 1;
        if(array == null || array.length == 0){
            return result;
        }

        while(i < j){
            if(array[i] + array[j] == sum){
                result.add(array[i]);
                result.add(array[j]);
                break;
            }

            if(array[i] + array[j] < sum){
                i++;
            }

            if(array[i] + array[j] > sum){
                j--;
            }
        }

        return result;
    }
}