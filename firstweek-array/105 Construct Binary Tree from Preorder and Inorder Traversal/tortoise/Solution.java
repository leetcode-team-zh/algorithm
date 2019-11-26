/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //1.¼ì²é
        if(preorder == null || inorder == null
                || preorder.length == 0 || preorder.length != inorder.length){
            return null;
        }

        //2.µÝ¹éÉú³ÉÊ÷
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

}