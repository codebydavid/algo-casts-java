package me.codebydavid.algocasts;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * PalindromeTest
 */
public class PalindromeTest {

    private static Stream<Arguments> getTestArguments() {
        return Stream.of(
            Arguments.of("aba", Boolean.TRUE),
            Arguments.of(" aba", Boolean.FALSE),
            Arguments.of("aba ", Boolean.FALSE),
            Arguments.of("greetings", Boolean.FALSE),
            Arguments.of("1000000001", Boolean.TRUE),
            Arguments.of("Fish hsif", Boolean.FALSE),
            Arguments.of("pennep", Boolean.TRUE)
        );
    }

    @ParameterizedTest
    @MethodSource("getTestArguments")
    public void testSolution1(String str, Boolean expected) {
        Boolean actual = Palindrome.isPalindrome1(str);
        if (expected) {
            assertTrue(actual, str + " is a palindrome.");
        } else {
            assertFalse(actual, str + " is not a palindrome.");
        }
    }

    @ParameterizedTest
    @MethodSource("getTestArguments")
    public void testSolution2(String str, Boolean expected) {
        Boolean actual = Palindrome.isPalindrome2(str);
        if (expected) {
            assertTrue(actual, str + " is a palindrome.");
        } else {
            assertFalse(actual, str + " is not a palindrome.");
        }
    }

    @ParameterizedTest
    @MethodSource("getTestArguments")
    public void testSolution3(String str, Boolean expected) {
        Boolean actual = Palindrome.isPalindrome3(str);
        if (expected) {
            assertTrue(actual, str + " is a palindrome.");
        } else {
            assertFalse(actual, str + " is not a palindrome.");
        }
    }

}
