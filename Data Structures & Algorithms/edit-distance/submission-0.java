
class Solution {
    public int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        // Base cases
        // Convert word1 into an empty string: delete all characters
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        // Convert an empty string into word2: insert all characters
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        // Fill DP table
        for (int i = 1; i <= m; i++) {

            for (int j = 1; j <= n; j++) {

                // Characters match: no operation needed
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {

                    dp[i][j] = dp[i - 1][j - 1];

                } else {

                    // Insert
                    int insert = dp[i][j - 1];

                    // Delete
                    int delete = dp[i - 1][j];

                    // Replace
                    int replace = dp[i - 1][j - 1];

                    dp[i][j] = 1 + Math.min(
                        insert,
                        Math.min(delete, replace)
                    );
                }
            }
        }

        return dp[m][n];
    }
}
