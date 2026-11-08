class Solution {
    public boolean canPartition(int[] nums) {

        int totalSum = 0;

        // Step 1: Calculate total sum
        for (int num : nums) {
            totalSum += num;
        }

        // Step 2: If sum is odd, return false
        if (totalSum % 2 != 0) {
            return false;
        }

        // Step 3: Find target
        int target = totalSum / 2;

        // Step 4: Create DP array
        boolean[] dp = new boolean[target + 1];

        // Step 5: Base case
        dp[0] = true;

        // Step 6: Process each number
        for (int num : nums) {

            for (int j = target; j >= num; j--) {

                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[target];
    }
}
