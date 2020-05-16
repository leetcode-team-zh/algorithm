package leetcode.d236;

import common.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //节点都是唯一的
        HashMap<Integer,TreeNode> map = new HashMap<>();
        Set<Integer> visit = new HashSet<>();

        dfs(root,map);

        while(p != null){
            //访问父亲节点
            visit.add(p.val);
            p = map.get(p.val);
        }

        while(q != null){
            if(visit.contains(q.val)){
                return q;
            }
            q = map.get(q.val);
        }

        return null;
    }

    private void dfs(TreeNode root,HashMap<Integer,TreeNode> map){
        if(root.left != null){
            map.put(root.left.val,root);
            dfs(root.left,map);
        }

        if(root.right != null){
            map.put(root.right.val,root);
            dfs(root.right,map);
        }
    }
}
