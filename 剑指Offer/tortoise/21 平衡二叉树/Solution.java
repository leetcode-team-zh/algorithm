package leetcode;


import common.TreeNode;

public class Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null) {
            return true;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        return Math.abs(rightHeight - leftHeight) <= 1 &&
                IsBalanced_Solution(root.left) &&
                IsBalanced_Solution(root.right);
    }

    private int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(getHeight(root.left),getHeight(root.right)) + 1;
    }
}
