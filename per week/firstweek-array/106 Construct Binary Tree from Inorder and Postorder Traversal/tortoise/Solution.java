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
   public TreeNode buildTree(int[] inorder, int[] postorder) {
        //1.检查
        if(postorder == null || inorder == null
                || postorder.length == 0 || postorder.length != inorder.length){
            return null;
        }

        //2.递归生成树
        return buildTree(postorder,0,postorder.length -1,inorder,0,inorder.length - 1);
    }

    private TreeNode buildTree(int[] postorder, int postLeft, int postRight,int[] inorder, int inLeft, int inRight) {
        if(postLeft > postRight){
            return null;
        }

        int rootValue =  postorder[postRight];
        TreeNode root = new TreeNode(rootValue);

        int rootInOrder = inLeft;
        while(inorder[rootInOrder] != rootValue){
            rootInOrder ++;
        }

        root.left = buildTree(postorder,postLeft,rootInOrder - inLeft + postLeft -1,
                inorder,inLeft,rootInOrder - 1);

        root.right = buildTree(postorder,rootInOrder - inLeft + postLeft,postRight -1,
                inorder,rootInOrder + 1,inRight);

        return root;
    }
}