package leetcode;

import common.TreeNode;

import java.util.ArrayList;
/**
 public class TreeNode {
 int val = 0;
 TreeNode left = null;
 TreeNode right = null;

 public TreeNode(int val) {
 this.val = val;

 }

 }
 */
public class Solution {
    ArrayList<Integer> path = new ArrayList<>();
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if(root == null){
            return result;
        }
        dfs(root,target);
        return result;
    }

    public void dfs(TreeNode root,int target){
        path.add(root.val);
        if(root.left == null  && root.right == null && root.val == target){
            result.add(new ArrayList<>(path));
        }
        if(root.left != null){
            dfs(root.left,target - root.val);
        }

        if(root.right != null){
            dfs(root.right,target - root.val);
        }

        path.remove(path.size() - 1);
    }
}