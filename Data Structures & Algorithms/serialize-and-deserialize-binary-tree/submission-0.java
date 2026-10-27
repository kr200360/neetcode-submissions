public class Codec {

    // Serialize the tree into a string
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfsSerialize(root, sb);
        return sb.toString();
    }

    private void dfsSerialize(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("N,");
            return;
        }

        sb.append(node.val).append(",");

        dfsSerialize(node.left, sb);
        dfsSerialize(node.right, sb);
    }

    // Deserialize the string back into a tree
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        int[] index = {0};

        return dfsDeserialize(nodes, index);
    }

    private TreeNode dfsDeserialize(String[] nodes, int[] index) {
        if (nodes[index[0]].equals("N")) {
            index[0]++;
            return null;
        }

        TreeNode node = new TreeNode(
            Integer.parseInt(nodes[index[0]])
        );
        index[0]++;

        node.left = dfsDeserialize(nodes, index);
        node.right = dfsDeserialize(nodes, index);

        return node;
    }
}