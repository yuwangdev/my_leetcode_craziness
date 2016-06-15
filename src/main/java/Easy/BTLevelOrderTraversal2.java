package Easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by yuwang on 6/15/16.
 */
public class BTLevelOrderTraversal2 {
    private List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> curLevel = new ArrayList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode n = queue.poll();
                curLevel.add(n.val);
                if (n.left != null) queue.add(n.left);
                if (n.right != null) queue.add(n.right);
            }
            res.add(0, curLevel);
        }

        return res;
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
