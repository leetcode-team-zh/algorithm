package leetcode;

import common.TreeNode;

public class Solution {
    String Serialize(TreeNode root) {
        if(root == null){
            return "";
        }

        StringBuilder sb = new StringBuilder();
        Serialize(root,sb);
        return sb.toString();
    }

    void Serialize(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("#,");
            return;
        }

        sb.append(root.val);
        sb.append(",");
        Serialize(root.left,sb);
        Serialize(root.right,sb);
    }

    TreeNode Deserialize(String str) {
        if(str.length() == 0){
            return null;
        }

        String[] s = str.split(",");
        return Deserialize(s);
    }

    int index = 0;
    TreeNode Deserialize(String[] s){
        if(s[index].equals("#")){
            index++;
            return null;
        }
        int val = Integer.valueOf(s[index]);
        index++;
        TreeNode node = new TreeNode(val);
        node.left = Deserialize(s);
        node.right = Deserialize(s);
        return node;
    }
}