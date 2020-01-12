package tree;

/**
 * 111. 二叉树的最小深度
 *
 * @author gaoyh
 */
public class MinLength {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);

        if (left == 0 || right == 0) {
            return 1 + right + left;
        }
        return Math.min(left, right) + 1;
    }
}
