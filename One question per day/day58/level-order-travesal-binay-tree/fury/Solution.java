public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> temp = new ArrayList<>();

            for (int i = 0; i < len && !queue.isEmpty(); i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    temp.add(node.val);
                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                }

            }
            res.add(temp);
        }

        return res;

    }
