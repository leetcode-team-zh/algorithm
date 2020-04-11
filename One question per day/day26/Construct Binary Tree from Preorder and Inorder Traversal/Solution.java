static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0)
            return null;
        else
            return buildTree(
                    preorder, 0, preorder.length - 1,
                    inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int start1, int end1, int[] inorder, int start2, int end2) {
        if (start1 > end1) return null;
        TreeNode root = new TreeNode(preorder[start1]);
        int index = start2;
        while (inorder[index] != preorder[start1]) index++;
        root.left = buildTree(preorder, start1 + 1, start1 + index - start2, inorder, start2, index - 1);
        root.right = buildTree(preorder, start1 + index - start2 + 1, end1, inorder, index + 1, end2);
        return root;
    }
