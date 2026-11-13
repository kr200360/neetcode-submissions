class Solution {

    public List<List<String>> partition(String s) {

        List<List<String>> ans = new ArrayList<>();

        backtrack(0, s, new ArrayList<>(), ans);

        return ans;
    }

    private void backtrack(
        int index,
        String s,
        List<String> current,
        List<List<String>> ans
    ) {

        // Base condition
        if (index == s.length()) {
            ans.add(new ArrayList<>(current));
            return;
        }

        // Try every possible substring
        for (int i = index; i < s.length(); i++) {

            // Check if substring is palindrome
            if (isPalindrome(s, index, i)) {

                // Pick the substring
                current.add(s.substring(index, i + 1));

                // Recursively process remaining string
                backtrack(i + 1, s, current, ans);

                // Backtracking
                current.remove(current.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {

        while (start < end) {

            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
}
