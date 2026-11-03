class Solution {

    public boolean isHappy(int n) {

        HashSet<Integer> seen = new HashSet<>();

        while (n != 1) {

            // Check whether number was already visited
            if (seen.contains(n)) {
                return false;
            }

            seen.add(n);

            // Calculate sum of squares of digits
            int sum = 0;

            while (n > 0) {

                int digit = n % 10;

                sum += digit * digit;

                n = n / 10;
            }

            n = sum;
        }

        return true;
    }
}
