package leetcode.d865;

import common.TreeNode;

public class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return depth(root).second;
    }

    private Pair depth(TreeNode root){
        if(root == null){
            return new Pair(0,null);
        }

        Pair l = depth(root.left);
        Pair r = depth(root.right);

        int dl = l.first;
        int dr = r.first;
        return new Pair(Math.max(dl,dr) + 1,dl == dr ? root : (dr > dl) ? l.second : r.second);
    }

    public class Pair{
        int first;
        TreeNode second;
        public Pair(int first,TreeNode second){
            this.first = first;
            this.second = second;
        }
    }
}
