package leetcode.d105;

import common.TreeNode;


/**
 * 从前序与中序遍历序列构造二叉树
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //1.检查
        if(preorder == null || inorder == null
                || preorder.length == 0 || preorder.length != inorder.length){
            return null;
        }

        //2.递归生成树
        return buildTree(preorder,0,preorder.length - 1,
                inorder,0,inorder.length -1);
    }


    private TreeNode buildTree(int[] preorder, int preLeft, int preRight,
                               int[] inorder, int inLeft, int inRight) {

        if(preLeft > preRight || inLeft > inRight){
            return null;
        }

        int rootValue =  preorder[preLeft];
        TreeNode root = new TreeNode(rootValue);

        int rootInOrder = inLeft;
        while(inorder[rootInOrder] != rootValue){
            rootInOrder ++;
        }

        root.left = buildTree(preorder,preLeft + 1,rootInOrder - inLeft + preLeft,
                inorder,inLeft,rootInOrder - 1);

        root.right = buildTree(preorder,rootInOrder - inLeft + preLeft + 1,preRight,
                inorder,rootInOrder + 1,inRight);

        return root;
    }

    public static void main(String[] args) {
        int[] pre = new int[]{1,2,3};
        int[] in = new int[]{1,3,2};
        Solution solution = new Solution();
        solution.buildTree(pre,in);
    }

}
