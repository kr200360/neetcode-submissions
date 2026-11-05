
class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {

        boolean x = false;
        boolean y = false;
        boolean z = false;

        for (int i = 0; i < triplets.length; i++) {

            // Ignore invalid triplets
            if (triplets[i][0] > target[0] ||
                triplets[i][1] > target[1] ||
                triplets[i][2] > target[2]) {

                continue;
            }

            // Check which target values we can obtain
            if (triplets[i][0] == target[0]) {
                x = true;
            }

            if (triplets[i][1] == target[1]) {
                y = true;
            }

            if (triplets[i][2] == target[2]) {
                z = true;
            }
        }

        return x && y && z;
    }
}
