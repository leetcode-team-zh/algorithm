public class Solution {
    //572. Subtree of Another Tree
    //Example 1:
    //Given tree s:
    //
    //     3
    //    / \
    //   4   5
    //  / \
    // 1   2
    //Given tree t:
    //   4
    //  / \
    // 1   2
    //Return true, because t has the same structure and node values with a subtree of s.
    //Example 2:
    //Given tree s:
    //
    //     3
    //    / \
    //   4   5
    //  / \
    // 1   2
    //    /
    //   0
    //Given tree t:
    //   4
    //  / \
    // 1   2
    //Return false.

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null)
            return false;
        if (isSame(s, t))
            return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;

        return s.val == t.val && isSame(s.left, t.left) && isSame(s.right, t.right);
    }
}

