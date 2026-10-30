class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // b -> a means b is a prerequisite of a
        for (int[] p : prerequisites) {
            int a = p[0];
            int b = p[1];

            graph.get(b).add(a);
        }

        // Track nodes in the current DFS path
        Set<Integer> path = new HashSet<>();

        // Check every course
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, graph, path)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(
        int course,
        List<List<Integer>> graph,
        Set<Integer> path
    ) {

        // Already in current path -> cycle
        if (path.contains(course)) {
            return false;
        }

        // No remaining neighbors -> already processed
        if (graph.get(course).isEmpty()) {
            return true;
        }

        // Add current course to DFS path
        path.add(course);

        // Explore all dependent courses
        for (int next : graph.get(course)) {

            if (!dfs(next, graph, path)) {
                return false;
            }
        }

        // Remove from current path
        path.remove(course);

        // Mark as completely processed
        graph.get(course).clear();

        return true;
    }
}
