class Solution {

    public int find(int x, int[] parent) {

        if (parent[x] != x) {
            parent[x] = find(parent[x], parent);
        }

        return parent[x];
    }

    public boolean union(int a, int b, int[] parent) {

        int parentA = find(a, parent);
        int parentB = find(b, parent);

        if (parentA == parentB) {
            return false;
        }

        parent[parentA] = parentB;

        return true;
    }

    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;

        int[] parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {

            int a = edge[0];
            int b = edge[1];

            if (!union(a, b, parent)) {
                return edge;
            }
        }

        return new int[0];
    }
}