package me.codebydavid.algocasts;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// --- Directions
// Given a string, return a new string with the reversed
// order of characters
// --- Examples
//   reverse('apple') === 'leppa'
//   reverse('hello') === 'olleh'
//   reverse('Greetings!') === '!sgniteerG'
public class ReverseString {

    /**
     * Reverse String using built-in method
     */
    public static String reverse1(String str) {
        List<String> charList = Arrays.asList(str.split(""));
        Collections.reverse(charList);
        return String.join("", charList);
    }

    /**
     * Reverse String using a for loop
     */
    public static String reverse2(String str) {
        String reversed = "";
        for (char c : str.toCharArray()) {
            reversed = c + reversed;
        }
        return reversed;
    }

    /**
     * Reverse String using reduce method (since JDK 1.8)
     */
    public static String reverse3(String str) {
        return Arrays.asList(str.split("")).stream()
            .reduce("", (reversed, c) -> c + reversed);
    }

}
