package me.codebydavid.algocasts;

import java.util.Arrays;
import java.util.List;

/**
 * Vowels
 */
public class Vowels {

    /**
     * Solution 1: iterative 
     */
    public static int vowels1(String str) {
        int count = 0;

        // define a list of vowel characters
        List<Character> checker =
            Arrays.asList(new Character[] { 'a', 'e', 'i', 'o', 'u' });

        // loop through each character of the string
        for (char c : str.toLowerCase().toCharArray()) {
            // increment the count if the character is in the vowels list
            if (checker.contains(c)) count++;
        }

        return count;
    }

    /**
     * Solution: regex
     */
    public static int vowels2(String str) {
        // Java String class does not have an equivalent method for
        // Javascript "match()". Instead use regex to replace all
        // non-vowel characters then return the lenght of result string.
        return str.toLowerCase().replaceAll("[^aeiou]", "").length();
    }
}