package leetcode.d98;

import common.TreeNode;

import java.util.Stack;

public class Solution {
//    public boolean isValidBST(TreeNode root) {
//        //中序遍历，比较是否是否有序的
//        Stack<TreeNode> stack = new Stack<>();
//        double inorder = - Double.MAX_VALUE;
//
//        while(!stack.isEmpty() || root != null){
//            while(root != null){
//                stack.push(root);
//                root = root.left;
//            }
//
//            root = stack.pop();
//            if(root.val <= inorder) return false;
//            inorder = root.val;
//            root = root.right;
//        }
//        return true;
//    }

    public boolean isValidBST(TreeNode root){
        if(root == null){
            return true;
        }

        return dfs(root,null,null);
    }

    private boolean dfs(TreeNode root,Integer min,Integer max){
        if(root == null){
            return true;
        }

        if(min != null && root.val <= min){
            return false;
        }

        if(max != null && root.val >= max){
            return false;
        }

        return dfs(root.left,min,root.val) && dfs(root.right,root.val,max);
    }

}
