static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0)
            return null;
        else
            return buildTree(
                    inorder, 0, inorder.length - 1,
                    postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int start1, int end1, int[] postorder, int start2, int end2) {
        if (start1 > end1) return null;
        TreeNode root = new TreeNode(postorder[end2]);
        int index = start1;
        while (inorder[index] != postorder[end2]) index++;
        root.left = buildTree(inorder, start1, index - 1, postorder, start2, start2 + index - start1 - 1);
        root.right = buildTree(inorder, index + 1, end1, postorder, start2 + index - start1, end2 - 1);
        return root;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            System.out.print("null ,");
            return;
        }
        System.out.print(root.val);
        inorder(root.left);
        inorder(root.right);
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        TreeNode root = solution2.buildTree(inorder, postorder);
        solution2.inorder(root);
    }

