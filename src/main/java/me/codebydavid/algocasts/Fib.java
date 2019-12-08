package me.codebydavid.algocasts;

import java.util.HashMap;
import java.util.Map;

// --- Directions
// Print out the n-th entry in the fibonacci series.
// The fibonacci series is an ordering of numbers where
// each number is the sum of the preceeding two.
// For example, the sequence
//  [0, 1, 1, 2, 3, 5, 8, 13, 21, 34]
// forms the first ten entries of the fibonacci series.
// Example:
//   fib(4) === 3
public class Fib {

    // Solution 1: Iterative
    // Complexity: n (linear)
    // Calculate all fib values up to "n"
    public static int fib1(int n) {
        // create an array to hold n fib numbers plus 0
        int[] numbers = new int[n + 1];

        // 0 & 1 can not be derived, so just initialize the values
        numbers[0] = 0;
        numbers[1] = 1;

        // calculate the numbers starting from second fib number
        for (int i = 2; i <= n; i++) {
            // current number is the sum of prev two numbers
            numbers[i] = numbers[i - 1] + numbers[i - 2];
        }

        return numbers[n];
    }

    /**
     * Solution 2: Recursive
     * Complexity: 2^n (exponential, very bad)
     * Recursively calculate the previous two numbers
     */
    public static int fib2(int n) {
        // fib numbers at 0 and 1 can not be calculated, return 0 or 1
        if (n < 2) return n;

        // fib value at "n" is the sum of previous 2 numbers
        return fib2(n - 1) + fib2(n - 2);
    }

    /**
     * Solution 3: Recursive with Memoization
     * Complexity: n (linear)
     * Use a Map to cache previous results. Return cached value if in cache,
     * otherwise calculate recursively using the previous two numbers.
     */
    public static int fib3(int n, Map<Integer, Integer> cache) {
        // handle 0 and 1
        if (n < 2) return n;

        // check cache
        if (cache.containsKey(n)) return cache.get(n);

        int number = fib3(n - 1, cache) + fib3(n - 2, cache);
        cache.put(n, number);

        return number;
    }

    // overload the method so an empty Map is created by default
    public static int fib3(int n) {
        return fib3(n, new HashMap<Integer, Integer>());
    }
}