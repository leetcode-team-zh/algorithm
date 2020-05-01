package leetcode.d655;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> result = new ArrayList<>();
        int height = height(root);
        int cell =  (int)(Math.pow(2,height) - 1);
        for(int i = 0 ; i < height; i++){
            List<String> list = new ArrayList<>();
            for(int j = 0 ; j < cell; j++){
                list.add("");
            }
            result.add(list);
        }
        dfs(root,result,0,0,cell);
        return result;
    }

    public void dfs(TreeNode root,List<List<String>> result,int high,int l,int r){
        if(root == null){
            return;
        }
        int mid = l + (r - l)/2;
        result.get(high).set(mid,root.val + "");
        dfs(root.left,result,high + 1,l,mid -1);
        dfs(root.right,result,high + 1, mid + 1,r);
    }

    private int height(TreeNode root){
        if(root == null){
            return 0;
        }
        return 1 + Math.max(height(root.left),height(root.right));
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);

        t1.left = t2;
        t1.right = t3;
        t3.right = t4;

        new Solution().printTree(t1);
    }
}
