
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        // Case 1: Both nodes are empty
        if (p == null && q == null) {
            return true;
        }

        // Case 2: Only one node is empty
        if (p == null || q == null) {
            return false;
        }

        // Case 3: Values are different
        if (p.val != q.val) {
            return false;
        }

        // Compare both left and right subtrees
        return isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }
}
