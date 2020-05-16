package leetcode.d572;

import common.TreeNode;

public class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(t == null) return true;   // t 为 null 一定都是 true
        if(s == null) return false;  // 这里 t 一定不为 null, 只要 s 为 null，肯定是 false
        return isSubtree(s.left, t) || isSubtree(s.right, t) || isSame(s,t);
    }

    private boolean isSame(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null){
            return true;
        }

        if(root1 == null || root2 == null){
            return false;
        }

        if(root1.val == root2.val){
            return isSame(root1.left,root2.left) && isSame(root1.right,root2.right);
        }
        return false;
    }
}
