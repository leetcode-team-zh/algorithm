package leetcode.d297;

import common.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return rserialize(root,"");

    }

    public String rserialize(TreeNode root, String str) {
        if(root == null){
            str += "null,";
        }else{
            str += str.valueOf(root.val) + ",";
            str = rserialize(root.left,str);
            str = rserialize(root.right,str);
        }
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        List<String> nodeList = new LinkedList<String>(Arrays.asList(nodes));
        return deserialize(nodeList);
    }

    public TreeNode deserialize(List<String> l) {
        if (l.get(0).equals("null")) {
            l.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
        l.remove(0);
        root.left = deserialize(l);
        root.right = deserialize(l);
        return root;
    }
}

