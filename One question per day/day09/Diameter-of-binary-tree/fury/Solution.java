class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        int max = getDepth(root.left) + getDepth(root.right);
        int leftMax = diameterOfBinaryTree(root.left);
        int rightMax = diameterOfBinaryTree(root.right);
        if (leftMax > max)
            max = leftMax;
        if (rightMax > max)
            max = rightMax;
        return max;
    }

    public int getDepth(TreeNode node) {
        if (node == null)
            return 0;
        else
            return Math.max(getDepth(node.left), getDepth(node.right)) + 1;
    }
}
