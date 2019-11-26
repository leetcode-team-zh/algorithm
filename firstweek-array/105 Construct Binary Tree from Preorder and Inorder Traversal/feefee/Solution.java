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
        if(preorder == null || preorder.length == 0){
            return null;
        }
        return innerBuild(preorder,0,preorder.length-1,inorder,0,inorder.length - 1);
    }

	//思路就是用前序遍历的第一个元素构建当前子树的根节点，并而该元素也是中序遍历数组中左右子树的分割点，找到它，就可以
	//递归到左右子树的创建中。 问题是这个寻找过程是O(n)的，所以最差条件下O(nlogn)
    private TreeNode innerBuild(int[] preOrder,int preStart,int preEnd,int[] inOrder,int inStart,int inEnd){
            TreeNode node = new TreeNode(preOrder[preStart]);
            if(preEnd == preStart ){
                return node;
            }
            int inOrderMid = index(inOrder,inStart,inEnd,preOrder[preStart]);
            int leftTreeCount = inOrderMid - inStart;
            int preOrderMid = preStart + leftTreeCount;
            if(preStart < preOrderMid){
                node.left = innerBuild(preOrder,preStart+1,preOrderMid,inOrder,inStart,inOrderMid-1);
            }
            if(preOrderMid < preEnd){
                node.right = innerBuild(preOrder,preOrderMid+1,preEnd,inOrder,inOrderMid+1,inEnd);
            }
            return node;

    }
    private int index(int[] nums,int start,int end,int num){
        for(int n = start;n<=end;n++){
            if(nums[n] == num){
                return n;
            }
        }
        return -1;
    }
}