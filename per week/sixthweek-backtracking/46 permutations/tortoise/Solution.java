package leetcode.d46;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return result;
        }

        boolean[] visited = new boolean[nums.length];
        dfs(nums,0,visited,new ArrayList<>(),result);
        return result;
    }

    private void dfs(int[] nums, int index,boolean[] visited, ArrayList<Integer> tmpList, List<List<Integer>> result) {
        if(index == nums.length){
            result.add(new ArrayList<>(tmpList));
            return;
        }

        for(int i = 0 ; i < nums.length ; i++){
            if(!visited[i]){
                visited[i] = true;
                tmpList.add(nums[i]);
                dfs(nums,index + 1,visited,tmpList,result);
                //回溯
                visited[i] = false;
                tmpList.remove(tmpList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        new Solution().permute(new int[]{1,2,3});
    }
}
