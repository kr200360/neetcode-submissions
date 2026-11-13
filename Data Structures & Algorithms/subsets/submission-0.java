class Solution {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        List<Integer> current = new ArrayList<>();

        generateSubsets(0, nums, current, result);

        return result;
    }

    static void generateSubsets(
        int index,
        int[] nums,
        List<Integer> current,
        List<List<Integer>> result
    ) {

        // Base condition
        if (index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Pick
        current.add(nums[index]);

        generateSubsets(index + 1, nums, current, result);

        // Backtrack
        current.remove(current.size() - 1);

        // Don't Pick
        generateSubsets(index + 1, nums, current, result);
    }
}
