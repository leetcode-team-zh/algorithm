package leetcode.d15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return res;
        }
        int size = nums.length;
        Arrays.sort(nums);
        for(int first = 0 ; first < size; first++){
            //过滤掉重复的
            if(first > 0 && nums[first] == nums[first -1]){
                continue;
            }

            //指向最右边的指针
            int third =  size - 1;
            int target = - nums[first];
            for(int second = first + 1; second < size; ++second){
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }

                while(second < third && nums[second] + nums[third] > target){
                    --third;
                }

                if(second == third){
                    break;
                }

                if(nums[second] + nums[third] == target){
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    res.add(list);
                }
            }
        }
        return res;
    }
}
