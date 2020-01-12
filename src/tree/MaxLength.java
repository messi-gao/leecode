package tree;

/**
 * 104 二叉树的最大深度
 * @author gaoyh
 */
public class MaxLength {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }
}
