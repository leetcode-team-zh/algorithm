package leetcode.d169;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        //题目中说明nums一定存在
        Arrays.stream(nums).forEach(num ->  map.compute(num ,(k,v) -> {
            if (v == null) return 1;
            else {
                return v + 1;
            }
        }));

        int key = 0;
        int value = 0;

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() > value){
                key = entry.getKey();
                value = entry.getValue();
            }
        }
        return key;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().majorityElement(new int[]{3,2,3}));
    }
}
