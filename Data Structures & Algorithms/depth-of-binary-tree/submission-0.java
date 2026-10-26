class Solution {
    public int maxDepth(TreeNode root) {

        // Base case: if the tree is empty
        if (root == null) {
            return 0;
        }

        // Find the depth of the left subtree
        int leftDepth = maxDepth(root.left);

        // Find the depth of the right subtree
        int rightDepth = maxDepth(root.right);

        // Return the greater depth + 1 for current node
        return 1 + Math.max(leftDepth, rightDepth);
    }
}