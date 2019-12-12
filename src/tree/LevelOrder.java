package tree;

import java.util.*;

public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> objects = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.pop();
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
                objects.add(treeNode.val);
            }
            list.add(objects);
        }
        return list;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        help(root, 0, list);
        return list;
    }

    private void help(TreeNode treeNode, Integer level, List<List<Integer>> list) {
        if (treeNode == null) {
            return;
        }
        if (list.size() == level) {
            list.add(new ArrayList<>());
        }
        list.get(level).add(treeNode.val);

        help(treeNode.left, level + 1, list);
        help(treeNode.right, level + 1, list);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode20 = new TreeNode(20);
        TreeNode treeNode15 = new TreeNode(15);
        TreeNode treeNode7 = new TreeNode(7);
        treeNode.left = treeNode9;
        treeNode.right = treeNode20;
        treeNode20.left = treeNode15;
        treeNode20.right = treeNode7;
        List<List<Integer>> lists = new LevelOrder().levelOrder2(treeNode);
    }
}
