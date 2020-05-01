package leetcode.d617;

import common.TreeNode;

public class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 != null && t2 != null){
            TreeNode root = new TreeNode(t1.val + t2.val);
            root.left = mergeTrees(t1.left,t2.left);
            root.right= mergeTrees(t1.right,t2.right);
            return root;
        }else{
            return t1 == null ?  t2: t1;
        }
    }
}
