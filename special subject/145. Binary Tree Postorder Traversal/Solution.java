package leetcode.d145;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        if(root == null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.addFirst(node.val);
            if(node.left != null){
                stack.add(node.left);
            }

            if(node.right != null){
                stack.add(node.right);
            }
        }
        return result;
    }

//   public List<Integer> postorderTraversal(TreeNode root) {
//         List<Integer> result = new ArrayList<>();
//         if(root == null){
//             return result;
//         }
//         Stack<Integer> stack = new Stack();
//         dfs(root,stack);
//         while(!stack.isEmpty()){
//             result.add(stack.pop());
//         }
//         return result;
//     }

//     private void dfs(TreeNode root,Stack<Integer> stack){
//         if(root == null){
//             return;
//         }
//         stack.add(root.val);

//          if(root.right != null){
//             dfs(root.right,stack);
//         }

//         if(root.left != null){
//             dfs(root.left,stack);
//         }

//     }
}
