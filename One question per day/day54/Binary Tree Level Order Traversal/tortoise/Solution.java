package leetcode.d102;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    // public List<List<Integer>> levelOrder(TreeNode root) {
    //     //广度优先遍历
    //     List<List<Integer>> result = new ArrayList<>();
    //     if(root == null){
    //         return result;
    //     }
    //     Queue<TreeNode> queue = new LinkedList();
    //     queue.offer(root);

    //     while(!queue.isEmpty()){
    //         int size = queue.size();
    //         List<Integer> list = new ArrayList<>();
    //         for(int i = 0 ; i < size ; i++){
    //             TreeNode node = queue.poll();
    //             list.add(node.val);
    //             if(node.left != null){
    //                 queue.offer(node.left);
    //             }

    //             if(node.right != null){
    //                 queue.offer(node.right);
    //             }
    //         }
    //         result.add(list);
    //     }

    //     return result;
    // }

    public List<List<Integer>> levelOrder(TreeNode root) {
        //深度遍历
        List<List<Integer>> result = new ArrayList();
        dfs(root,1,result);
        return result;
    }

    private void dfs(TreeNode node,int high,List<List<Integer>> result){
        if(node == null){
            return;
        }

        //创建数组
        while(result.size() < high){
            result.add(new ArrayList<>());
        }

        //添加元素
        result.get(high - 1).add(node.val);
        //递归左
        dfs(node.left,high + 1,result);
        //递归右
        dfs(node.right,high + 1,result);
    }
}
