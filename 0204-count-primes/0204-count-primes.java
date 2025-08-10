class Solution {
    public int countPrimes(int n) {
        
        
        // Step 1: Handle edge cases
        if (n <= 2) {
            return 0;
        }

        // Step 2: Create our list and assume everything is prime
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);

        // Step 3: Manually correct 0 and 1
        isPrime[0] = false;
        isPrime[1] = false;

        // Step 4: The main process of eliminating non-primes
        for (int p = 2; p * p < n; p++) {
            if (isPrime[p]) {
                // Step 5: Mark all multiples
                for (int i = p * p; i < n; i += p) {
                    isPrime[i] = false;
                }
            }
        }

        // Step 6: Count the results
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        return count;
    }
}
    