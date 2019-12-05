package me.codebydavid.algocasts;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * --- Directions Check to see if two provided strings are anagrams of
 * eachother. One string is an anagram of another if it uses the same characters
 * in the same quantity. Only consider characters, not spaces or punctuation.
 * Consider capital letters to be the same as lower case --- Examples
 * anagrams('rail safety', 'fairy tales') --> True anagrams('RAIL! SAFETY!',
 * 'fairy tales') --> True anagrams('Hi there', 'Bye there') --> False
 */
public class Anagrams {

    // helper method to remove non-word characters and change to lower case
    private static String clean(String str) {
        return str.replaceAll("[\\W]", "").toLowerCase();
    }

    /**
     * Solution 1: compare character counts using maps
     */    
    public static boolean anagrams1(String stringA, String stringB) {
        Map<Character, Integer> mapA = toCharMap(stringA);
        Map<Character, Integer> mapB = toCharMap(stringB);

        // return false if the 2 maps are different size
        if (mapA.size() != mapB.size()) return false;

        // return false if any of char counts are different
        for (Character c : mapA.keySet()) {
            if (mapA.get(c) != mapB.get(c)) return false;
        }

        // if both above checks passed, then the two strings are anagrams
        return true;
    }

    private static Map<Character, Integer> toCharMap(String str) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : clean(str).toCharArray()) {
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
        }
        return map;
    }

    /**
     * Solution 2: strings are anagrams if "sorted" strings are the same
     */
    public static boolean anagrams2(String stringA, String stringB) {
        return sortString(stringA).equals(sortString(stringB));
    }

    private static String sortString(String str) {
        char[] chars = clean(str).toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

}