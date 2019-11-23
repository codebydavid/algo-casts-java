package me.codebydavid.algocasts;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Palindrome {

    /**
     * Use Java built-in method to reverse the input string then
     * compare the reversed string with the input.
     */
    public static boolean isPalindrome1(String str) {
        List<String> strList = Arrays.asList(str.split(""));
        Collections.reverse(strList);
        String reversed = String.join("", strList);
        return str.equals(reversed);
    }

    /**
     * Use "Stream.allMatch" for equivalent behavior as "Array.prototype.every"
     */
    public static boolean isPalindrome2(String str) {
        return IntStream.range(0, str.length()).allMatch(
            i -> str.charAt(i) == str.charAt(str.length() - i - 1)
        );
    }

    /**
     * Similar to solution 2 but avoid duplicate checks
     */
    public static boolean isPalindrome3(String str) {
        int midIndex = Math.round(str.length()/2);
        return IntStream.range(0, midIndex).allMatch(
            i -> str.charAt(i) == str.charAt(str.length() - i - 1)
        );
    }

}
