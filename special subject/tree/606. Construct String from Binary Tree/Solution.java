package leetcode.d606;

import common.TreeNode;

public class Solution {
    public String tree2str(TreeNode t) {
        if(t == null){
            return "";
        }

        if(t.left == null && t.right == null){
            return  t.val + "";
        }

        if(t.right == null){
            return t.val + "(" + tree2str(t.left) +")";
        }

        return t.val + "(" + tree2str(t.left) +")" + "(" + tree2str(t.right) + ")";
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);

        t1.left = t2;
        t1.right = t3;
        t3.right = t4;

        new Solution().tree2str(t1);
    }

}
