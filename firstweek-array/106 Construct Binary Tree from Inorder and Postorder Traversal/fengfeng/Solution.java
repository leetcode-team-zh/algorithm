 import java.util.*;
class Solution {
    Map<Integer,Integer> map;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null || inorder.length ==0){
            return null;
        }
        map  = new HashMap<Integer,Integer>();
        for(int n=0;n< inorder.length;n++){
            map.put(inorder[n],n);
        }
        return innerBuild(inorder,0,inorder.length-1,postorder,0,postorder.length - 1);
    }

	
    private TreeNode innerBuild(int[] inorder,int inStart,int inEnd,int[] postorder,int postStart,int postEnd){
        TreeNode node = new TreeNode(postorder[postEnd]);

        int inMid = map.get(postorder[postEnd]);
        int postLeftEnd = inMid - inStart - 1 + postStart;
        int postRightStart = postLeftEnd + 1;
        
        if(postLeftEnd >= postStart){
            node.left = innerBuild(inorder,inStart,inMid-1,postorder,postStart,postLeftEnd);
        }
        if(postRightStart <= postEnd - 1){
            node.right = innerBuild(inorder,inMid+1,inEnd,postorder,postRightStart,postEnd-1);
        }

        return node;
    }



}