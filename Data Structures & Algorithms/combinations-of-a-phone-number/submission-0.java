class Solution {

    Map<Character, String> map = new HashMap<>();
    List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {

        if (digits.length() == 0) {
            return result;
        }

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        backtrack(0, digits, new StringBuilder());

        return result;
    }

    public void backtrack(int index,
                          String digits,
                          StringBuilder current) {

        // Base condition
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // Get letters for current digit
        String letters = map.get(digits.charAt(index));

        // Explore each possible character
        for (int i = 0; i < letters.length(); i++) {

            // Choose
            current.append(letters.charAt(i));

            // Explore next digit
            backtrack(index + 1, digits, current);

            // Backtrack (undo choice)
            current.deleteCharAt(current.length() - 1);
        }
    }
}