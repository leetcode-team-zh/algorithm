package leetcode.d543;

import common.TreeNode;

public class Solution {
    int result = 1;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return result -1;
    }

    private int dfs(TreeNode root) {
        if(root == null) return 0;
        int leftLength = dfs(root.left);
        int rightLength = dfs(root.right);
        result = Math.max(result,leftLength + rightLength + 1);
        return Math.max(leftLength , rightLength) + 1;
    }
}
