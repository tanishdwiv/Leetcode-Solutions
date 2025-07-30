class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        
      int n = arr.length;

        // Our search space for the fraction's value is between 0.0 and 1.0.
        double low = 0.0;
        double high = 1.0;

        // We will continue to guess until our search space is tiny.
        while (low < high) {
            // Step 1: Make a guess. Let's guess the middle of our current range.
            double guess = low + (high - low) / 2;

            // --- Helper variables for our check ---
            // 'count' will store how many fractions are smaller than or equal to our 'guess'.
            int count = 0;

            // 'bestNumerator' and 'bestDenominator' will track the largest fraction we find
            // that is still smaller than our 'guess'. This is our candidate for the answer.
            int bestNumerator = 0;
            int bestDenominator = 1; // Initialize to 0/1 to avoid division by zero.

            // Step 2: Count fractions smaller than our guess.
            // We use an efficient two-pointer approach. 'i' points to the numerator, 'j' to the denominator.
            int j = 1; // Start denominator pointer at the second element.
            for (int i = 0; i < n - 1; i++) { // Iterate through each possible numerator.

                // Move the denominator pointer 'j' forward until the fraction arr[i]/arr[j] is
                // small enough to be less than or equal to our 'guess'.
                // The check `arr[i] > guess * arr[j]` is a rewrite of `arr[i] / arr[j] > guess`
                // to avoid floating-point division issues.
                while (j < n && arr[i] > guess * arr[j]) {
                    j++;
                }

                // If the denominator pointer has gone past the end, no more valid fractions
                // can be formed with the remaining numerators, so we can stop.
                if (j == n) {
                    break;
                }

                // At this point, for the current numerator arr[i], all denominators from arr[j]
                // to the end of the array will form fractions smaller than our guess.
                // The number of such fractions is (n - j).
                count += (n - j);

                // We also need to find the best candidate for the answer. The fraction arr[i]/arr[j]
                // is the largest fraction we've found so far for this numerator 'i' that is still
                // smaller than our guess. We check if it's the best overall candidate we've seen.
                // The check `bestNumerator * arr[j] < arr[i] * bestDenominator` is a cross-multiplication
                // way to compare `bestNumerator/bestDenominator < arr[i]/arr[j]`.
                if (bestNumerator * arr[j] < arr[i] * bestDenominator) {
                    bestNumerator = arr[i];
                    bestDenominator = arr[j];
                }
            }

            // Step 3: Adjust our search space based on the count.
            if (count == k) {
                // If we found exactly k smaller fractions, our candidate is the answer.
                return new int[]{bestNumerator, bestDenominator};
            } else if (count < k) {
                // If we found fewer than k fractions, our guess was too low.
                // We need to guess a larger value.
                low = guess;
            } else { // count > k
                // If we found more than k fractions, our guess was too high.
                // We need to guess a smaller value.
                high = guess;
            }
        }

        // This line is technically unreachable if the input is valid,
        // as the loop will always find the answer.
        return new int[]{};
    }
}
