
class Solution {
    public String minWindow(String s, String t) {
        int[] need = new int[128];
        int[] window = new int[128];

        // Count the required characters
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }

        int left = 0;
        int have = 0;
        int minLength = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // Add the current character to the window
            window[c]++;

            // Count it only if it was still needed
            if (need[c] > 0 && window[c] <= need[c]) {
                have++;
            }

            // Shrink while all required characters are matched
            while (have == t.length()) {
                int length = right - left + 1;

                // Save the shortest valid window
                if (length < minLength) {
                    minLength = length;
                    start = left;
                }

                char leftChar = s.charAt(left);
                window[leftChar]--;

                // Removing this character may invalidate the window
                if (need[leftChar] > 0
                        && window[leftChar] < need[leftChar]) {
                    have--;
                }

                left++;
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(start, start + minLength);
    }
}
