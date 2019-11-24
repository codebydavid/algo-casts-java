package me.codebydavid.algocasts;

// --- Directions
// Write a program that console logs the numbers
// from 1 to n. But for multiples of three print
// “fizz” instead of the number and for the multiples
// of five print “buzz”. For numbers which are multiples
// of both three and five print “fizzbuzz”.
// --- Example
//   fizzBuzz(5);
//   1
//   2
//   fizz
//   4
//   buzz
public class FizzBuzz {

    /**
     * Modified to return an array of Strings instead of printing to console
     */
    public static String[] fizzBuss(int n) {
        String[] result = new String[n];
        for (int i = 1; i <= n; i++) {
            // if i is multiple of 3 & 5
            if (i % 15 == 0) {
                result[i - 1] = "fizzbuzz";
            } else if (i % 3 == 0) {
                result[i - 1] = "fizz";
            } else if (i % 5 == 0) {
                result[i - 1] = "buzz";
            } else {
                result[i - 1] = String.valueOf(i);
            }
        }
        return result;
    }
}