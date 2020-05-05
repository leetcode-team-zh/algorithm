public class Solution {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        boolean result = true;
        if (root.left != null) result = isValidBST(root.left) && root.left.val < root.val;
        if (root.right != null) result &= isValidBST(root.right) && root.right.val > root.val;
        return result;
    }


    TreeNode pre = null;

    public boolean isValidBST1(TreeNode root) {
        return preOrderTravesal(root);
    }

    private boolean preOrderTravesal(TreeNode root) {
        if (root == null) return true;
        boolean result = true;
        result &= preOrderTravesal(root.left);
        result &= (pre == null || root.val > pre.val);
        pre = root;
        result &= preOrderTravesal(root.right);
        return result;
    }

    public static void main(String[] args) {
        //[10,5,15,null,null,6,20]
        TreeNode root = new TreeNode(10);
        TreeNode rootLeft = new TreeNode(5);
        TreeNode rootRight = new TreeNode(15);
        TreeNode rightLeft = new TreeNode(6);
        TreeNode rightRight = new TreeNode(20);

        root.left = rootLeft;
        root.right = rootRight;
        rootRight.left = rightLeft;
        rootRight.right = rightRight;

        Solution solution = new Solution();
        System.out.println(solution.isValidBST1(root));


        //  10
        // 5 15
        //  6   20
    }
}

