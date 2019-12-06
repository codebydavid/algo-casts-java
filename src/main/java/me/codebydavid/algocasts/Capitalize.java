package me.codebydavid.algocasts;

import java.util.ArrayList;
import java.util.List;

// --- Directions
// Write a function that accepts a string.  The function should
// capitalize the first letter of each word in the string then
// return the capitalized string.
// --- Examples
//   capitalize('a short sentence') --> 'A Short Sentence'
//   capitalize('a lazy fox') --> 'A Lazy Fox'
//   capitalize('look, it is working!') --> 'Look, It Is Working!'
public class Capitalize {

    /**
     * Solution 1
     * 
     * Split the sentence into words then capitalize the first letter
     * of each word and finally join the words back into a sentence.
     */
    public static String capitalize1(String str) {
        List<String> words = new ArrayList<String>();

        for (String word : str.split(" ")) {
            words.add(word.toUpperCase().charAt(0) + word.substring(1));
        }

        return String.join(" ", words);
    }

    /**
     * Solution 2
     * 
     * Capitalize the letter if the previous character is a space.
     * Always capitalize the first letter of the sentence. Initialize
     * the result with the first letter capitalized. 
     */
    public static String capitalize2(String str) {
        String result = String.valueOf(str.charAt(0)).toUpperCase();

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i - 1) == ' ') {
                result += str.substring(i, i + 1).toUpperCase();
            } else {
                result += str.charAt(i);
            }
        }

        return result;
    }

}
