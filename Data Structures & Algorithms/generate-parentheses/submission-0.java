class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();

        char[] current = new char[2 * n];

        backtrack(0, 0, 0, n, current, ans);

        return ans;
    }

    private void backtrack(
        int idx, int open, int close, int n,
        char[] current, List<String> ans
    ) {
        // Base case
        if (idx == 2 * n) {
            ans.add(new String(current));
            return;
        }

        // Option 1: Add opening bracket
        if (open < n) {
            current[idx] = '(';

            backtrack(idx + 1, open + 1, close,
                      n, current, ans);
        }

        // Option 2: Add closing bracket
        if (close < open) {
            current[idx] = ')';

            backtrack(idx + 1, open, close + 1,
                      n, current, ans);
        }
    }
}
