
class Solution {
    public boolean isValidSudoku(char[][] board) {

        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        // Initialize all HashSets
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        // Traverse the entire Sudoku board
        for (int r = 0; r < 9; r++) {

            for (int c = 0; c < 9; c++) {

                char num = board[r][c];

                // Ignore empty cells
                if (num == '.') {
                    continue;
                }

                // Find the corresponding 3x3 box
                int boxIndex = (r / 3) * 3 + (c / 3);

                // Check duplicates
                if (rows[r].contains(num) ||
                    cols[c].contains(num) ||
                    boxes[boxIndex].contains(num)) {

                    return false;
                }

                // Insert the number into all three sets
                rows[r].add(num);
                cols[c].add(num);
                boxes[boxIndex].add(num);
            }
        }

        return true;
    }
}
