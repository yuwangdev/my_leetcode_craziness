package Easy;

/**
 * Created by yuwang on 6/15/16.
 */
public class MaxDepthBT {
    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
