package leetcode.d669;

import common.TreeNode;

public class Solution {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root == null) return null;

        if(root.val < L){
            //减去左枝
            return trimBST(root.right,L,R);
        }

        if(root.val > R){
            //减去右枝
            return trimBST(root.left,L,R);
        }

        root.left = trimBST(root.left,L,R);
        root.right = trimBST(root.right,L,R);
        return  root;
    }
}
