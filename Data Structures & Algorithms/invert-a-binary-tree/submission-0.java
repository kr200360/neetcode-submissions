
class Solution {
    public TreeNode invertTree(TreeNode root) {

        // Step 1: If the tree is empty, return null
        if (root == null) {
            return null;
        }

        // Step 2: Swap the left and right children
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Step 3: Invert the left subtree
        invertTree(root.left);

        // Step 4: Invert the right subtree
        invertTree(root.right);

        // Step 5: Return the root
        return root;
    }
}
