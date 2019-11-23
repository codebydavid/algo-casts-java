package me.codebydavid.algocasts;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * ReverseInt
 */
public class ReverseInt {

    /**
     * Reverse the number as a string then apply the sign 
     */
    public static int reverse(int n) {
        String str = String.valueOf(n);
        List<String> strList = Arrays.asList(str.split(""));
        Collections.reverse(strList);
        String reversed = String.join("", strList);

        // Integer.parseInt does not handle format like 5-
        // strip the negative sign before parsing
        reversed = reversed.replace("-", "");

        return Integer.signum(n) * Integer.parseInt(reversed);
    }
}