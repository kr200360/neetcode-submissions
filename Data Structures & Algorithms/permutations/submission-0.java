class Solution {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        boolean[] used = new boolean[nums.length];

        backtrack(nums, used, new ArrayList<>(), ans);

        return ans;
    }

    private void backtrack(
        int[] nums,
        boolean[] used,
        List<Integer> current,
        List<List<Integer>> ans
    ) {

        // Base condition
        if (current.size() == nums.length) {
            ans.add(new ArrayList<>(current));
            return;
        }

        // Explore all elements
        for (int i = 0; i < nums.length; i++) {

            // Skip already used elements
            if (used[i]) {
                continue;
            }

            // Pick the element
            current.add(nums[i]);
            used[i] = true;

            // Recursion
            backtrack(nums, used, current, ans);

            // Backtracking
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}
