class Solution {
    public int sumNumbers(TreeNode root) {
        if(root==null){
            return sum;
        }
        solve(root,0);
        return sum;
    }
    int sum = 0;

    public void solve(TreeNode root,int prefix){
        int currentVal = root.val + 10 * prefix;

        if(root.left != null){
            solve(root.left,currentVal);
        }       
        if(root.right != null){
            solve(root.right,currentVal);
        }

        if(root.left == null && root.right == null){
            sum += currentVal;
        }

    }
}
