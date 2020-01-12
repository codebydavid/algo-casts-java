package me.codebydavid.algocasts;

import java.util.HashMap;
import java.util.Map;

// --- Directions
// Given a string, return the character that is most
// commonly used in the string.
// --- Examples
// maxChar("abcccccccd") === "c"
// maxChar("apple 1231111") === "1"
public class MaxChar {

    /**
     * Finds the character with the max count in the string.
     * This solution uses 2 loops to count and find the max.
     */
    public static char maxChar1(String str) {
        Map<Character, Integer> charMap = new HashMap<Character, Integer>();
        Integer max = 0;
        Character maxChar = Character.MIN_VALUE;

        // get character counts
        for (char c : str.toCharArray()) {
            // NOTE: Java doesn't have truthy test like JavaScript
            charMap.put(c, charMap.containsKey(c) ? charMap.get(c) + 1 : 1);
        }

        // find the character with the max count
        for (Character c : charMap.keySet()) {
            if (charMap.get(c) > max) {
                max = charMap.get(c);
                maxChar = c; 
            }
        }

        return maxChar;
    }

    /**
     * Finds the character with the max count in the string.
     * This solution uses a single loop to count and find the max.
     */
    public static char maxChar2(String str) {
        Map<Character, Integer> charMap = new HashMap<Character, Integer>();
        Integer max = 0;
        Character maxChar = Character.MIN_VALUE;

        // get character counts
        for (char c : str.toCharArray()) {
            // NOTE: Java doesn't have truthy test like JavaScript
            charMap.put(c, charMap.containsKey(c) ? charMap.get(c) + 1 : 1);

            // check if the curr char has more count then max
            // set max to curr char if curr char count is more
            if (charMap.get(c) > max) {
                max = charMap.get(c);
                maxChar = c; 
            }
        }

        return maxChar;
    }
}