package leetcode.d637;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        List<Pair> list = new ArrayList<>();

        dfs(root,1,list);

        for(Pair pair : list){
            result.add(pair.sum / pair.num);
        }
        return result;
    }

    private void dfs(TreeNode root, int high, List<Pair> list) {
        if(root == null){
            return;
        }
        if(list.size() < high){
            list.add(new Pair());
        }

        Pair pair = list.get(high);
        pair.sum += root.val;
        pair.num ++;
        dfs(root.left,high + 1,list);
        dfs(root.right,high + 1,list);
    }

    public class Pair{
        int num;
        double sum;
    }
}
