package leetcode;


import common.TreeNode;

public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre == null || in == null){
            return null;
        }
        //1,2,4,7,3,5,6,8
        //4,7,2,1,5,3,8,6
        return buildTree(pre,0,pre.length - 1,in,0,in.length - 1);
    }

    private TreeNode buildTree(int[] pre,int pLeft,int pRight,int[] in,int iLeft,int iRight){
        if(pLeft > pRight){
            return null;
        }

        //找出pre[pLeft] 在中序的位置
        TreeNode root = new TreeNode(pre[pLeft]);
        int rootIndex = -1;
        for(int i = 0 ; i < in.length; i++){
            if(in[i] == pre[pLeft]){
                rootIndex =  i;
                break;
            }
        }

        int length = rootIndex - iLeft;
        root.left = buildTree(pre,pLeft + 1,pLeft + length,in,iLeft,rootIndex - 1);
        root.right = buildTree(pre,pLeft + length + 1,pRight,in,rootIndex + 1,iRight);
        return root;
    }
}
