package Easy;

/**
 * Created by yuwang on 6/15/16.
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false; // root == null


        return root.left == null && root.right == null && sum == root.val
                || hasPathSum(root.left, sum - root.val)
                || hasPathSum(root.right, sum - root.val);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
