package leetcode.d560;

import java.util.HashMap;

public class Solution {
    // public int subarraySum(int[] nums, int k) {
    //     int count = 0;
    //     for(int i = 0; i < nums.length; i++){
    //         int sum = 0;
    //         for(int j = i; j >=0 ; j --){
    //             sum += nums[j];
    //             if(sum == k){
    //                 count++;
    //             }
    //         }
    //     }
    //     return count;
    // }

    //前缀数
    public int subarraySum(int[] nums, int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);

        int pre = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            pre += nums[i]; //前面的所有的和
            if(map.containsKey(pre - k)){
                //存在，则更新
                count += map.get(pre -k);
            }
            //插入前缀和
            map.put(pre,map.getOrDefault(pre,0) + 1);
        }
        return  count;
    }
}
