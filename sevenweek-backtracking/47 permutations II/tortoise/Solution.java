package leetcode.d47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return res;
        }
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        dfs(nums,visited,0,new ArrayList<>(),res);
        return res;
    }

    private void dfs(int[] nums, boolean[] visited,int index, List<Integer> tmp, List<List<Integer>> res) {
        if(index == nums.length){
            if(!res.contains(tmp)) {
                res.add(new ArrayList<>(tmp));
            }
        }

        for(int i = 0; i < nums.length; i++){
            if(!visited[i]){
                visited[i] = true;
                tmp.add(nums[i]);
                dfs(nums,visited,index + 1,tmp,res);

                //回溯
                tmp.remove(tmp.size() - 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        new Solution().permuteUnique(new int[]{1,1,3});
    }
}
