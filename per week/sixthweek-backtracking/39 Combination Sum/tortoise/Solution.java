package leetcode.d39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(candidates == null || candidates.length == 0){
            return result;
        }
        //进行排序，方便剪枝
        Arrays.sort(candidates);
        dfs(candidates,target,0,0,new ArrayList<>(),result);
        return result;
    }

    /**
     *  回溯
     * @param candidates 候选
     * @param target 目标
     * @param index  候选数组下标
     * @param tmpSum 临时的商
     * @param tmpList 临时胡List
     * @param result 结果集合
     */
    private void dfs(int[] candidates, int target, int index, int tmpSum, ArrayList<Integer> tmpList, List<List<Integer>> result) {
        if(tmpSum >= target){
            if(tmpSum == target){
                result.add(new ArrayList<>(tmpList));
            }
            return;
        }

        for(int i = index; i < candidates.length ; i++){
            if(tmpSum + candidates[i] <= target){
                tmpList.add(candidates[i]);
                dfs(candidates,target,i,tmpSum + candidates[i],tmpList,result);
                //回溯
                tmpList.remove(tmpList.size() - 1);
            }else {
                //剪枝
                break;
            }
        }
    }

    public static void main(String[] args) {
        new Solution().combinationSum(new int[]{2,3,6,7},7);
    }
}
