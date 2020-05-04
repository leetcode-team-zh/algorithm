package leetcode;


import common.TreeNode;

public class Solution {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1 == null || root2 == null){
            return false;
        }
        if(isSame(root1,root2)){
            return true;
        }
        return HasSubtree(root1.left,root2) || HasSubtree(root1.right,root2);
    }

    public boolean isSame(TreeNode root1,TreeNode root2){
        if(root1 == null && root2 == null){
            return true;
        }else if(root1 != null && root2 != null && root1.val == root2.val){
            return isSame(root1.left,root2.left) && isSame(root1.right,root2.right);
        }else if(root1 != null && root2 == null){
            return true;
        }else{
            return false;
        }
    }
    
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(8);
        TreeNode t2 = new TreeNode(8);
        TreeNode t3 = new TreeNode(7);
        TreeNode t4 = new TreeNode(9);
        TreeNode t5 = new TreeNode(2);
        TreeNode t6 = new TreeNode(4);
        TreeNode t7 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;

        TreeNode t8 = new TreeNode(8);
        TreeNode t9 = new TreeNode(9);
        TreeNode t10 = new TreeNode(2);
        t8.left = t9;
        t8.right = t10;

        System.out.println(new Solution().HasSubtree(t1,t8));
    }
}
