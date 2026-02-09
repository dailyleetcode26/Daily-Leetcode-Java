import java.util.*;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {

    // Brute force: collect values, sort them, rebuild BST
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> values = new ArrayList<>();

        inorder(root, values);          // collect values
        Collections.sort(values);       // sort values

        return buildBST(values, 0, values.size() - 1);
    }

    // Inorder traversal to collect values
    private void inorder(TreeNode node, List<Integer> values) {
        if (node == null) return;

        inorder(node.left, values);
        values.add(node.val);
        inorder(node.right, values);
    }

    // Build balanced BST from sorted values
    private TreeNode buildBST(List<Integer> values, int left, int right) {
        if (left > right) return null;

        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(values.get(mid));

        root.left = buildBST(values, left, mid - 1);
        root.right = buildBST(values, mid + 1, right);

        return root;
    }
}
