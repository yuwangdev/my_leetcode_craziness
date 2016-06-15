package Easy;

/**
 * Created by yuwang on 6/15/16.
 */
public class BalancedBT {

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        if (getHeight(root) == -1)
            return false;
        return true;
    }

    public int getHeight(TreeNode root) {
        if (root == null)
            return 0;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if (left == -1 || right == -1)


            return -1;
        if (Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
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