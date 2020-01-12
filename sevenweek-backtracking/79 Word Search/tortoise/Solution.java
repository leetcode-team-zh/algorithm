package leetcode.d78;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return result;
        }
        Arrays.sort(nums);
        dfs(nums,0,new ArrayList<>(),result);
        return result;
    }

    private void dfs(int[] nums, int index, ArrayList<Integer> tmpList, List<List<Integer>> result) {
        result.add(new ArrayList<>(tmpList));
        for(int i = index; i < nums.length ; i++){
            tmpList.add(nums[i]);
            dfs(nums,i + 1,tmpList,result);
            tmpList.remove(tmpList.size() - 1);
        }
    }

    public static void main(String[] args) {
        new Solution().subsets(new int[]{1,2,3});
    }
}
