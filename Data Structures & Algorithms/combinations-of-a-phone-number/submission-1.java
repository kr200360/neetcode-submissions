class Solution {

    private static final String[] KEYPAD = {
        "", "", "abc", "def", "ghi",
        "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        if (digits == null || digits.isEmpty()) {
            return result;
        }

        backtrack(digits, 0, new StringBuilder(), result);

        return result;
    }

    public void backtrack(
        String digits,
        int index,
        StringBuilder current,
        List<String> result
    ) {

        // Base condition
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // Get letters corresponding to digit
        String letters = KEYPAD[digits.charAt(index) - '0'];

        // Explore each letter
        for (int i = 0; i < letters.length(); i++) {

            // Choose
            current.append(letters.charAt(i));

            // Explore
            backtrack(digits, index + 1, current, result);

            // Undo
            current.deleteCharAt(current.length() - 1);
        }
    }
}