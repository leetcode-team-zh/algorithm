package leetcode.d40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(candidates == null || candidates.length == 0){
            return result;
        }

        Arrays.sort(candidates);
        dfs(candidates,target,0,0,new ArrayList<>(),result);
        return result;
    }

    private void dfs(int[] candidates, int target, int index, int tmpSum, ArrayList<Integer> tmpList, List<List<Integer>> result) {
        if(tmpSum >= target || index == candidates.length){
            if(tmpSum == target){
                result.add(new ArrayList<>(tmpList));
            }
            return;
        }

        for(int i = index ; i < candidates.length; i++){
            //去掉连续重复的
            if(i != index && candidates[i] == candidates[i-1]){
                continue;
            }
            if(tmpSum + candidates[i] <= target){
                tmpList.add(candidates[i]);
                dfs(candidates,target,i + 1,tmpSum + candidates[i],tmpList,result);
                //回溯
                tmpList.remove(tmpList.size() - 1);
            }else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        new Solution().combinationSum2(new int[]{10,1,2,7,6,1,5},8);
    }
}
