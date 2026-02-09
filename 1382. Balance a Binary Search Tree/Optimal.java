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

    // Optimal: use inorder traversal directly on BST nodes
    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();

        inorder(root, nodes);   // store nodes in sorted order

        return buildBalancedBST(nodes, 0, nodes.size() - 1);
    }

    // Inorder traversal of BST
    private void inorder(TreeNode node, List<TreeNode> nodes) {
        if (node == null) return;

        inorder(node.left, nodes);
        nodes.add(node);
        inorder(node.right, nodes);
    }

    // Build balanced BST using middle node
    private TreeNode buildBalancedBST(List<TreeNode> nodes, int left, int right) {
        if (left > right) return null;

        int mid = (left + right) / 2;
        TreeNode root = nodes.get(mid);

        root.left = buildBalancedBST(nodes, left, mid - 1);
        root.right = buildBalancedBST(nodes, mid + 1, right);

        return root;
    }
}
