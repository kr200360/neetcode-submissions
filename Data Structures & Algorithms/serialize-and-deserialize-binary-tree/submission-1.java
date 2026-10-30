
public class Codec {

    // Serialize: Tree -> String
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfsSerialize(root, sb);
        return sb.toString();
    }

    private void dfsSerialize(TreeNode node, StringBuilder sb) {

        // Base case: null node
        if (node == null) {
            sb.append("N,");
            return;
        }

        // Store current node
        sb.append(node.val).append(",");

        // Traverse left subtree
        dfsSerialize(node.left, sb);

        // Traverse right subtree
        dfsSerialize(node.right, sb);
    }

    // Deserialize: String -> Tree
    public TreeNode deserialize(String data) {

        String[] values = data.split(",");
        int[] index = {0};

        return dfsDeserialize(values, index);
    }

    private TreeNode dfsDeserialize(String[] values, int[] index) {

        // Read the next value
        String value = values[index[0]];
        index[0]++;

        // Null marker means no node
        if (value.equals("N")) {
            return null;
        }

        // Create current node
        TreeNode node = new TreeNode(Integer.parseInt(value));

        // Reconstruct left subtree
        node.left = dfsDeserialize(values, index);

        // Reconstruct right subtree
        node.right = dfsDeserialize(values, index);

        return node;
    }
}
