package leetcode;


import common.TreeNode;

import java.util.ArrayList;

public class Solution {
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if(pRoot == null){
            return list;
        }

        dfs(pRoot,1,list);
        return list;
    }

    private void dfs(TreeNode root,int depth,ArrayList<ArrayList<Integer>> list){
        if(root == null){
            return;
        }

        if(list.size() < depth){
            list.add(new ArrayList<Integer>());
        }

        list.get(depth - 1).add(root.val);

        dfs(root.left,depth + 1,list);
        dfs(root.right,depth + 1,list);
    }
}
