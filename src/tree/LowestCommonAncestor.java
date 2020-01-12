package tree;

/**
 * 235. 二叉搜索树的最近公共祖先
 * @author gaoyh
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val) {
                root = p.left;
            } else if (p.val > root.val && q.val > root.val) {
                root = p.right;
            } else {
                return root;
            }
        }
        return root;
    }

    public static void main(String[] args) {

    }
}
