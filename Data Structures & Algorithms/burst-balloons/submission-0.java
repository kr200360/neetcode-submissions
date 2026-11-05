
class Solution {
    public int maxCoins(int[] nums) {

        int n = nums.length;

        // Add 1 at both boundaries
        int[] arr = new int[n + 2];

        arr[0] = 1;
        arr[n + 1] = 1;

        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }

        // DP table
        int[][] dp = new int[n + 2][n + 2];

        // Length of interval
        for (int len = 2; len < n + 2; len++) {

            for (int l = 0; l + len < n + 2; l++) {

                int r = l + len;

                // Try every balloon as the last balloon
                for (int k = l + 1; k < r; k++) {

                    int coins = dp[l][k]
                              + dp[k][r]
                              + arr[l] * arr[k] * arr[r];

                    dp[l][r] = Math.max(dp[l][r], coins);
                }
            }
        }

        return dp[0][n + 1];
    }
}
