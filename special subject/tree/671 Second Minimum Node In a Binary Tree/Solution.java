package leetcode.d671;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null){
            return -1;
        }
        int s1 = root.val;
        int s2 = Integer.MAX_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean found = false;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.val > s1 && node.val <= s2){
                s2 = node.val;
                found = true;
                //不需要增加孩子节点
                continue;
            }

            if(node.left != null){
                //如果有左孩子，肯定有右孩子
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

        return found ? s2 : -1;
    }
}
